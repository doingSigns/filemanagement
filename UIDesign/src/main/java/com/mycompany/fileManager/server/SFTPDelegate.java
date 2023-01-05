/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fileManager.server;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;
import java.io.File;
import java.util.Properties;

public class SFTPDelegate {

    private final static JSch jsch = new JSch();

    public static void copyFile(String fileId, File file, FileServer fileServer) throws JSchException, SftpException {
        try {

            FileServerCredentials serverCredentials = fileServer.getConfig();

            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");

            Session session;

            session = jsch.getSession(serverCredentials.getUsername(), serverCredentials.getHost(), serverCredentials.getPort());
            session.setPassword(serverCredentials.getPassword());

            session.setConfig(config);
            session.connect(10000);

            Channel channel = session.openChannel("sftp");
            channel.connect(5000);

            ChannelSftp sftpChannel = (ChannelSftp) channel;

            sftpChannel.put(file.getAbsolutePath(), "/usr/" + fileId);

            sftpChannel.disconnect();
            sftpChannel.exit();

            session.disconnect();
        } catch (JSchException | SftpException ex) {
            ex.printStackTrace();
            throw ex;
        }
    }
    
    public void deleteFile (String fileId, FileServer fileServer) throws JSchException, SftpException {
         try {

            FileServerCredentials serverCredentials = fileServer.getConfig();

            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");

            Session session;

            session = jsch.getSession(serverCredentials.getUsername(), serverCredentials.getHost(), serverCredentials.getPort());
            session.setPassword(serverCredentials.getPassword());

            session.setConfig(config);
            session.connect(10000);

            Channel channel = session.openChannel("sftp");
            channel.connect(5000);

            ChannelSftp sftpChannel = (ChannelSftp) channel;

            sftpChannel.rm( "/usr/" + fileId);
          
            Boolean success = true;
            if (success){
                System.out.println("File deleted successfully");
            }
            
            sftpChannel.disconnect();
            sftpChannel.exit();
            session.disconnect();
         }catch(JSchException | SftpException ex) {
            ex.printStackTrace();
            throw ex;
         }
        
    }
}
