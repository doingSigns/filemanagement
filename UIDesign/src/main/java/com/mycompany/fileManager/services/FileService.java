/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fileManager.services;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import com.mycompany.fileManager.database.DatabaseSetup;
import com.mycompany.fileManager.security.SecurityContextHolder;
import com.mycompany.fileManager.server.FileServer;
import com.mycompany.fileManager.server.SFTPDelegate;
import com.mycompany.fileManager.storage.FileChunk;
import com.mycompany.fileManager.storage.FileDescription;
import com.mycompany.fileManager.storage.StoredFile;
import com.mycompany.fileManager.utils.FileUtils;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FileService {

    private final List<FileServer> FILE_SERVERS = Arrays.asList(FileServer.CONTAINER_ONE, FileServer.CONTAINER_TWO, FileServer.CONTAINER_THREE, FileServer.CONTAINER_FOUR);
    private static int NO_OF_FILE_CHUNKS = 4;

    public void uploadFile(File file) throws IOException, JSchException, SftpException, SQLException {

       String fileId = FileUtils.getUniqueId();
       

        StoredFile dbFile = new StoredFile();
        dbFile.setOwnerUserId(SecurityContextHolder.context.getUserId());
        dbFile.setFileChunks(new ArrayList());
        dbFile.setFileId(fileId);
        dbFile.setSharedUserIds(new ArrayList());
        dbFile.setFileName(file.getName());
        dbFile.setFileDescription(new FileDescription(FileUtils.currentTimeStamp(), FileUtils.getFileSizeInKb(file)));

        List<File> fileChunks = FileUtils.splitFileIntoChunks(file, NO_OF_FILE_CHUNKS);

        for (File chunk : fileChunks) {

            FileServer destinationFileServer = FILE_SERVERS.get(fileChunks.indexOf(chunk));
            SFTPDelegate.copyFile(dbFile.getFileId(), file, destinationFileServer);

            FileChunk fileChunk = new FileChunk();
            fileChunk.setEncrypted(false);
            fileChunk.setFileId(dbFile.getFileId());
            fileChunk.setFileServerId(destinationFileServer.getServerId());

            dbFile.getFileChunks().add(fileChunk);
        }

        DatabaseSetup.filesDatabase.saveFile(dbFile);
    }

    public StoredFile renameFile(StoredFile file, String newFileName) throws SQLException {

        file.setFileName(newFileName);
        DatabaseSetup.filesDatabase.saveFile(file);

        return file;

    }
}
