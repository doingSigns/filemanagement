/*

    Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
    Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template */

package com.mycompany.fileManager.server;

/** *

    @author adeshileosunkoya */ import java.io.FileInputStream; import java.io.FileOutputStream; import java.security.SecureRandom; import javax.crypto.Cipher; import javax.crypto.CipherInputStream; import javax.crypto.CipherOutputStream; import javax.crypto.SecretKey; import javax.crypto.SecretKeyFactory; import javax.crypto.spec.PBEKeySpec; import javax.crypto.spec.PBEParameterSpec;

public class FileEncryption { 
    private static final int ITERATION_COUNT = 65536; 
    private static final int KEY_LENGTH = 128; 
    private static final String ALGORITHM = "AES"; 
    private static final String TRANSFORMATION = "PBEWithHmacSHA256AndAES_128";

public static void encrypt(String fileName, String password) throws Exception {
    SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(TRANSFORMATION);
    PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray());
    SecretKey key = keyFactory.generateSecret(keySpec);

    byte[] salt = new byte[8];
    SecureRandom secureRandom = new SecureRandom();
    secureRandom.nextBytes(salt);

    PBEParameterSpec parameterSpec = new PBEParameterSpec(salt, ITERATION_COUNT);

    Cipher cipher = Cipher.getInstance(TRANSFORMATION);
    cipher.init(Cipher.ENCRYPT_MODE, key, parameterSpec);

    CipherOutputStream cipherOutputStream;
    try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
        cipherOutputStream = new CipherOutputStream(new FileOutputStream(fileName + ".encrypted"), cipher);
        byte[] buffer = new byte[1024];
        int numRead;
        while ((numRead = fileInputStream.read(buffer)) != -1) {
            cipherOutputStream.write(buffer, 0, numRead);
        }
    }
    cipherOutputStream.close();
}

public static void decrypt(String fileName, String password) throws Exception {
    SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(TRANSFORMATION);
    PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray());
    SecretKey key = keyFactory.generateSecret(keySpec);

    FileOutputStream fileOutputStream;
    try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
        CipherInputStream cipherInputStream = new CipherInputStream(fileInputStream, keyFactory.getInstance(TRANSFORMATION));
        fileOutputStream = new FileOutputStream(fileName.replace(".encrypted", ""));
        byte[] buffer = new byte[1024];
        int numRead;
        while ((numRead = cipherInputStream.read(buffer)) != -1) {
            fileOutputStream.write(buffer, 0, numRead);
        }
    }
    fileOutputStream.close();
}

}