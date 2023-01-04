/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fileManager;

/**
 *
 * @author ntu-user
 */
public class FileDescription {

    private String fileName;
    private String created;
    private int fileSizeInKb;

    public FileDescription(String fileName, String created, int fileSizeInKb) {
        this.fileName = fileName;
        this.created = created;
        this.fileSizeInKb = fileSizeInKb;
    }
    
    

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public int getFileSizeInKb() {
        return fileSizeInKb;
    }

    public void setFileSizeInKb(int fileSizeInKb) {
        this.fileSizeInKb = fileSizeInKb;
    }
}
    

