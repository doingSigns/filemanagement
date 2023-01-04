/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fileManager.storage;

public class FileChunk {
    private String fileId;
    private boolean encrypted;
    private String fileServerId;

    public FileChunk() {
    }
    

    public FileChunk(String fileId, boolean encrypted, String fileServerId) {
        this.fileId = fileId;
        this.encrypted = encrypted;
        this.fileServerId = fileServerId;
    }
   
    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public boolean isEncrypted() {
        return encrypted;
    }

    public void setEncrypted(boolean encrypted) {
        this.encrypted = encrypted;
    }

    public String getFileServerId() {
        return fileServerId;
    }

    public void setFileServerId(String fileServerId) {
        this.fileServerId = fileServerId;
    }
}
