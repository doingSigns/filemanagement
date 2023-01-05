/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fileManager.storage;

import java.util.ArrayList;
import java.util.List;

public class StoredFile {

    private String fileId;
    private String fileName;
    private List<FileChunk> fileChunks = new ArrayList();
    private FileDescription fileDescription;

    private String ownerUserId;
    private List<String> sharedUserIds = new ArrayList();

    public StoredFile(String fileId, String fileName, FileDescription fileDescription, String ownerUserId) {
        this.fileId = fileId;
        this.fileName = fileName;
        this.fileDescription = fileDescription;
        this.ownerUserId = ownerUserId;
    }

    public StoredFile() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
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
