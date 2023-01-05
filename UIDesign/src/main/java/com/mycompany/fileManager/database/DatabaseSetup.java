/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fileManager.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseSetup {

    public static int DB_TIME_OUT = 30;
    public static String SALT_VALUE;

    public static FilesDatabase filesDatabase;
    public static UsersDatabase usersDatabase;

    private static Connection connection;
    private static String dbUrl;

    public DatabaseSetup(String dbFileName) throws SQLException {
        DatabaseSetup.dbUrl = "jdbc:sqlite:" + dbFileName;
        connection = DriverManager.getConnection(dbUrl);
    }

    public void init() throws SQLException {

        filesDatabase = new FilesDatabase();
        filesDatabase.createFilesTable(getConnection());

        usersDatabase = new UsersDatabase();
        usersDatabase.createTable(getConnection());
        
    }

    public static Connection getConnection() throws SQLException {
        if (!connection.isClosed()) {
            return connection;
        }

        connection = DriverManager.getConnection(dbUrl);
        return connection;
    }
}
