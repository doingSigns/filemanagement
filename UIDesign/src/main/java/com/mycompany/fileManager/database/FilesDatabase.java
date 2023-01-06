/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fileManager.database;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mycompany.fileManager.database.abstracts.FileOperationsInterface;
import com.mycompany.fileManager.storage.FileChunk;
import com.mycompany.fileManager.storage.FileDescription;
import com.mycompany.fileManager.storage.StoredFile;
import com.mycompany.fileManager.utils.PasswordUtil;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FilesDatabase implements FileOperationsInterface {

    @Override
    public List<StoredFile> getUserFiles(String userId) {
        
            List<StoredFile> storedFiles = new ArrayList<>();
         try {
             
          

            ResultSet rs = DatabaseSetup.getConnection().createStatement().executeQuery("select file_id, file_description from " + DatabaseTableNames.FILES);
            
           

            while (rs.next()) {
                //FileName , Container , Time Created , FileSize 
                
                String fileId = rs.getString("file_id");
               
                String fileDescriptionJson = rs.getString("file_description");
                System.out.println("Log File Description " + fileDescriptionJson);
                Gson gson = new Gson ();
              
                JsonObject fileDescriptionJsonObject = gson.fromJson(fileDescriptionJson, JsonObject.class);
                String fileName = fileDescriptionJsonObject.get("fileName").getAsString();
                String createdAt = fileDescriptionJsonObject.get("created").getAsString();
                double fileSize = fileDescriptionJsonObject.get("fileSizeInKb").getAsDouble();
                
                
              
                StoredFile storedfile = new StoredFile (fileId, fileName, new FileDescription(createdAt,fileSize),  userId);
                storedFiles.add(storedfile);
                }
            }
        catch (SQLException ex) {
            Logger.getLogger(UsersDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return storedFiles;
    }
    

    @Override
    public List<StoredFile> getUserSharedFiles(String userId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public StoredFile saveFile(StoredFile storedFile) throws SQLException {

        String sql = "INSERT OR REPLACE INTO "
                + DatabaseTableNames.FILES
                + "(file_id, file_name, owner_user_id, shared_user_ids, file_chunks, file_description) "
                + "VALUES(?,?,?,?,?,?)";

        Gson gson = new Gson();

        PreparedStatement pstmt = DatabaseSetup.getConnection().prepareStatement(sql);
        pstmt.setString(1, storedFile.getFileId());
        pstmt.setString(2, storedFile.getFileName());
        pstmt.setString(3, storedFile.getOwnerUserId());
        pstmt.setString(4, gson.toJson(storedFile.getSharedUserIds()));
        pstmt.setString(5, gson.toJson(storedFile.getFileChunks()));
        pstmt.setString(6, gson.toJson(storedFile.getFileDescription()));
        pstmt.executeUpdate();

        return storedFile;
    }

    @Override
    public void createFilesTable(Connection connection) throws SQLException {
        try {
            String createFilesTableSqlCommand = "CREATE TABLE IF NOT EXISTS "
                    + DatabaseTableNames.FILES
                    + " "
                    + "("
                    + "file_id VARCHAR(32) NOT NULL UNIQUE PRIMARY KEY,"
                    + "file_name VARCHAR(200) NOT NULL UNIQUE,"
                    + "owner_user_id VARCHAR(32) NOT NULL,"
                    + "shared_user_ids TEXT,"
                    + "file_chunks TEXT,"
                    + "file_description TEXT"
                    + ")";

            connection.createStatement().executeUpdate(createFilesTableSqlCommand);
        } catch (SQLException ex) {
            Logger.getLogger(FilesDatabase.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    public StoredFile deleteFile(StoredFile storedFile) throws SQLException {
        
        try{

        String sql = "DELETE FROM "
                + DatabaseTableNames.FILES
                + " WHERE file_name = (?);";
        
        Gson gson = new Gson () ;

        PreparedStatement pstmt = DatabaseSetup.getConnection().prepareStatement(sql);
        pstmt.setString(1, storedFile.getFileId());
        
          pstmt.executeUpdate();
        
           return storedFile;
    }catch (SQLException ex) {
            Logger.getLogger(FilesDatabase.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }
    
    
}
