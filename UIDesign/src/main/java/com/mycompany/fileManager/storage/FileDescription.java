/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fileManager.storage;

public class FileDescription {

    private String created;
    private double fileSizeInKb;

    public FileDescription(String created, double fileSizeInKb) {
        this.created = created;
        this.fileSizeInKb = fileSizeInKb;
    }
    
    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public double getFileSizeInKb() {
        return fileSizeInKb;
    }

    public void setFileSizeInKb(double fileSizeInKb) {
        this.fileSizeInKb = fileSizeInKb;
    }
}
