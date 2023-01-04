/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fileManager;

/**
 *
 * @author ntu-user
 */

     
public class FileServer implements FileServerOperations {
    
    
    public final static FileServer CONTAINER_ONE = new FileServer("CONTAINER_ONE", new FileServerCredentials("root", "root", "0.0.0.0", 2200));
    public final static FileServer CONTAINER_TWO = new FileServer("CONTAINER_TWO", new FileServerCredentials("root", "root", "0.0.0.0", 3300));

    private String serverId;
    private FileServerCredentials config;

    public FileServer(String serverId, FileServerCredentials config) {
        this.serverId = serverId;
        this.config = config;
    }

    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    public FileServerCredentials getConfig() {
        return config;
    }

    public void setConfig(FileServerCredentials config) {
        this.config = config;
    }

    @Override
    public FileServer getFileServerById(String serverId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
    

