/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fileManager.database.abstracts;

import com.mycompany.fileManager.storage.StoredFile;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface FileOperationsInterface {
    
    List<StoredFile> getUserFiles(String userId);
    List<StoredFile> getUserSharedFiles(String userId);
    StoredFile saveFile(StoredFile file) throws SQLException;
    void createFilesTable(Connection connection) throws SQLException;
    
}
