/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fileManager.database;

import com.mycompany.fileManager.model.User;
import com.mycompany.fileManager.storage.StoredFile;
import com.mycompany.fileManager.utils.PasswordUtil;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsersDatabase {

    public UsersDatabase() {
    }

    public void createTable(Connection connection) {
        try {
            var statement = connection.createStatement();
            statement.setQueryTimeout(DatabaseSetup.DB_TIME_OUT);

            statement.executeUpdate("create table if not exists " + DatabaseTableNames.USERS + "  (username varchar, passwordHash varchar , isAdmin varchar,firstName varchar , lastName varchar, email varchar)");

        } catch (SQLException ex) {
            Logger.getLogger(UsersDatabase.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(UsersDatabase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public boolean authenticateUser(String username, String passwordHash) throws InvalidKeySpecException {
        Boolean flag = false;

        try {

            ResultSet rs = DatabaseSetup.getConnection().createStatement().executeQuery("select username, passwordHash from " + DatabaseTableNames.USERS);
            String inPass = PasswordUtil.generateSecurePassword(passwordHash);

            while (rs.next()) {
                if (username.equals(rs.getString("username")) && rs.getString("passwordHash").equals(inPass)) {
                    flag = true;
                    break;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }

        return flag;
    }

    public void addUser(User user) throws InvalidKeySpecException, SQLException {
        DatabaseSetup.getConnection().createStatement().executeUpdate("insert into " + DatabaseTableNames.USERS + " (username, passwordHash,isAdmin,firstName,lastName,email) values('" + user.getUsername() + "','" + PasswordUtil.generateSecurePassword(user.getPassword()) + "','" + user.getAdmin() + "','" + user.getFirstName() + "','" + user.getLastName() + "','" + user.getEmail() + "')");
    }
    
  //  public void delUser(String username) throws InvalidKeySpecException, SQLException {
   //     DatabaseSetup.getConnection().createStatement().executeUpdate("delete from " + DatabaseTableNames.USERS + " where username = '" + username +"');
    
//}
     public void delUser(String username) throws SQLException {

        try {

            String sql = "DELETE FROM "
                    + DatabaseTableNames.USERS
                    + " WHERE username = (?);";

            PreparedStatement pstmt = DatabaseSetup.getConnection().prepareStatement(sql);
            pstmt.setString(1, username);

            pstmt.executeUpdate();

            
        } catch (SQLException ex) {
            Logger.getLogger(UsersDatabase.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    public boolean userExists(String username) {
        Boolean flag = false;
        try {
            ResultSet rs = DatabaseSetup.getConnection().createStatement().executeQuery("select username from " + DatabaseTableNames.USERS);
            while (rs.next()) {
                if (username.equals(rs.getString("username"))) {
                    flag = true;
                    break;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }
}
