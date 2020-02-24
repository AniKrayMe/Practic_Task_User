package com.company.services;

import com.company.constant.MariaDBConstant;
import com.company.objects.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    private static UserService objectRefrense = null;


    private UserService() {
    }

    public static UserService getInstance() {
        if (objectRefrense == null ) {
            objectRefrense = new UserService();
            return objectRefrense;
        } else {
            return objectRefrense;
        }
    }


    public void createUser(User user) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection( MariaDBConstant.DB_URL, MariaDBConstant.user, MariaDBConstant.pass);
            if (conn != null) {
                String query = "INSERT iNTO user (name, sure_name) VALUES (?,?)";
                PreparedStatement preparedStatement = conn.prepareStatement( query );
                preparedStatement.setString( 1, user.getName() );
                preparedStatement.setString( 2, user.getSureName() );
                preparedStatement.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void printUserByID(User user, int id){

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(MariaDBConstant.DB_URL, MariaDBConstant.user, MariaDBConstant.pass);
            if (conn != null) {
                String query = "SELECT user.id = ? FROM user" ;
                PreparedStatement preparedStatement = conn.prepareStatement( query );
                preparedStatement.setInt(  1,id );
                preparedStatement.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }



    public void updateUserByID(User user, int id){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(MariaDBConstant.DB_URL, MariaDBConstant.user, MariaDBConstant.pass);
            if (conn != null) {
                String query = "UPDATE  task SET name = ?, sure_name = ? WHERE id = ?" ;
                PreparedStatement preparedStatement = conn.prepareStatement( query );
                preparedStatement.setString( 1,user.getName() );
                preparedStatement.setString( 2,user.getSureName() );
                preparedStatement.setInt( 3, id);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void deleteUserByID( int id){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(MariaDBConstant.DB_URL, MariaDBConstant.user, MariaDBConstant.pass);
            if (conn != null) {
                String query = "DELETE FROM user  WHERE id = ?" ;
                PreparedStatement preparedStatement = conn.prepareStatement( query );
                preparedStatement.setInt( 1, id);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }


}
