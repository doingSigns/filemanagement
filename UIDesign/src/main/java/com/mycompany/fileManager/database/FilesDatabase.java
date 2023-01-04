/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fileManager.database;

import com.google.gson.Gson;
import com.mycompany.fileManager.database.abstracts.FileOperationsInterface;
import com.mycompany.fileManager.storage.StoredFile;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FilesDatabase implements FileOperationsInterface {

    @Override
    public List<StoredFile> getUserFiles(String userId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<StoredFile> getUserSharedFiles(String userId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public StoredFile saveFile(StoredFile storedFile) throws SQLException {

        String sql = "INSERT OR REPLACE INTO "
                + DatabaseTableNames.FILES
                + "(file_id, owner_user_id, shared_user_ids, file_chunks, file_description) "
                + "VALUES(?,?,?,?,?)";
        
        Gson gson = new Gson();
        
        PreparedStatement pstmt = DatabaseSetup.getConnection().prepareStatement(sql);
        pstmt.setString(1, storedFile.getFileId());
        pstmt.setString(2, storedFile.getOwnerUserId());
        pstmt.setString(3, gson.toJson(storedFile.getSharedUserIds()));
        pstmt.setString(4, gson.toJson(storedFile.getFileChunks()));
        pstmt.setString(5, gson.toJson(storedFile.getFileDescription()));
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
}
