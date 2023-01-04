/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fileManager;

/**
 *
 * @author ntu-user
 */
public class FileChunk {
    
    private String fileChunkId;
    private String fileId;
    private boolean encrypted;
    private String fileServerId;

    public FileChunk(String fileChunkId, String fileId, boolean encrypted, String fileServerId) {
        this.fileChunkId = fileChunkId;
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

    public String getFileChunkId() {
        return fileChunkId;
    }

    public void setFileChunkId(String fileChunkId) {
        this.fileChunkId = fileChunkId;
    }
}


