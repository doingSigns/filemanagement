/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fileManager;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ntu-user
 */
public class StoredFile {
    

    private String fileId;
    private List<FileChunk> fileChunks = new ArrayList();
    private FileDescription fileDescription;
    
    private String ownerUserId;
    private List<String> sharedUserIds = new ArrayList();

    public StoredFile(String fileId, FileDescription fileDescription, String ownerUserId) {
        this.fileId = fileId;
        this.fileDescription = fileDescription;
        this.ownerUserId = ownerUserId;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public List<FileChunk> getFileChunks() {
        return fileChunks;
    }

    public void setFileChunks(List<FileChunk> fileChunks) {
        this.fileChunks = fileChunks;
    }

    public FileDescription getFileDescription() {
        return fileDescription;
    }

    public void setFileDescription(FileDescription fileDescription) {
        this.fileDescription = fileDescription;
    }

    public String getOwnerUserId() {
        return ownerUserId;
    }

    public void setOwnerUserId(String ownerUserId) {
        this.ownerUserId = ownerUserId;
    }

    public List<String> getSharedUserIds() {
        return sharedUserIds;
    }

    public void setSharedUserIds(List<String> sharedUserIds) {
        this.sharedUserIds = sharedUserIds;
    }
    
}