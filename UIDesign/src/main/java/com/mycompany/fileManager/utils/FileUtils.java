/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fileManager.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class FileUtils {

    public static final String TEMP_DIRECTORY = "tmp";
    public static final String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";

    public static String getUniqueId() {
        return java.util.UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static long getFileSizeInBytes(File file) {
        return file.length();
    }

    public static double getFileSizeInKb(File file) {
        return (double) (getFileSizeInBytes(file) / 1024);
    }

    public static String currentTimeStamp() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
        return sdf.format(cal.getTime());
    }

    public static List<File> splitFileIntoChunks(File file, int noOfFiles) throws IOException {
        List<File> list = new ArrayList<>();
        int maxChunkSize = getMaxiumumFileChunkSizeInBytes(getFileSizeInBytes(file), noOfFiles);
        try (InputStream in = Files.newInputStream(file.toPath())) {
            final byte[] buffer = new byte[maxChunkSize];
            int dataRead = in.read(buffer);
            while (dataRead > -1) {
                File fileChunk = createTmpFile(buffer, dataRead);
                list.add(fileChunk);
                dataRead = in.read(buffer);
            }
        }
        return list;

    }

    public static File createTmpFile(byte[] buffer, int length) throws IOException {
        File outPutFile = File.createTempFile("temp-", "-chunk");
        // File outPutFile = File.createTempFile(null, null);
        try (FileOutputStream fos = new FileOutputStream(outPutFile)) {
            fos.write(buffer, 0, length);
        }
        return outPutFile;
    }

    public static int getMaxiumumFileChunkSizeInBytes(long totalFileSizeInBytes, int desriedNumberOfChunks) {
        if (totalFileSizeInBytes % desriedNumberOfChunks != 0) {
            totalFileSizeInBytes = ((totalFileSizeInBytes / desriedNumberOfChunks) + 1) * desriedNumberOfChunks;
        }
        long x = totalFileSizeInBytes / desriedNumberOfChunks;
        if (x > Integer.MAX_VALUE) {
            throw new NumberFormatException("Error: Byte chunk too large to create");

        }
        return (int) x;
    }

}
