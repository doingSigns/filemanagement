/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fileManager.server;

public class FileServer implements FileServerOperations {
    
    private final static String CONTAINER_ONE_ID = "CONTAINER_ONE_ID";
    private final static String CONTAINER_TWO_ID = "CONTAINER_TWO_ID";
    private final static String CONTAINER_THREE_ID = "CONTAINER_THREE_ID";
    private final static String CONTAINER_FOUR_ID = "CONTAINER_FOUR_ID";

    public final static FileServer CONTAINER_ONE = new FileServer(CONTAINER_ONE_ID, new FileServerCredentials("root", "soft40051_pass", "172.18.0.3", 22));
    public final static FileServer CONTAINER_TWO = new FileServer(CONTAINER_TWO_ID, new FileServerCredentials("root", "soft40051_pass", "172.18.0.4", 22));
    public final static FileServer CONTAINER_THREE = new FileServer(CONTAINER_THREE_ID, new FileServerCredentials("root", "soft40051_pass", "172.18.0.5", 22));
    public final static FileServer CONTAINER_FOUR = new FileServer(CONTAINER_FOUR_ID, new FileServerCredentials("root", "soft40051_pass", "172.18.0.6", 22));

    
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
        switch (serverId) {
            case CONTAINER_ONE_ID:
                return CONTAINER_ONE;
            case CONTAINER_TWO_ID:
                return CONTAINER_TWO;
            case CONTAINER_THREE_ID:
                return CONTAINER_THREE;
            case CONTAINER_FOUR_ID:
                return CONTAINER_FOUR;
            default:
                throw new UnsupportedOperationException("File server not found"); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }
}
