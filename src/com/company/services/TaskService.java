package com.company.services;

import com.company.constant.MariaDBConstant;
import com.company.objects.Task;
import com.company.objects.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskService {
    private static TaskService objectRefrense = null;


    private TaskService() {
    }

    public static TaskService getInstance() {
        if (objectRefrense == null ) {
            objectRefrense = new TaskService();
            return objectRefrense;
        } else {
            return objectRefrense;
        }
    }
    public void createTask(Task task) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection( MariaDBConstant.DB_URL, MariaDBConstant.user, MariaDBConstant.pass);
            if (conn != null) {
                String query = "INSERT iNTO task (name, sure_name, user_id) VALUES (?,?,?)";
                PreparedStatement preparedStatement = conn.prepareStatement( query );
                preparedStatement.setString( 1, task.getName() );
                preparedStatement.setString( 2, task.getState() );
                preparedStatement.setInt( 2, task.getUserID() );
                preparedStatement.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    public List<Task> showTasks(){

        Connection conn = null;
        List<Task> movies = new ArrayList<>(  );
        try {
            conn = DriverManager.getConnection(MariaDBConstant.DB_URL, MariaDBConstant.user, MariaDBConstant.pass);
            if (conn != null) {
                String query = "SELECT * FROM task";
                PreparedStatement preparedStatement = conn.prepareStatement( query );
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    String name = resultSet.getString( "name" );
                    String state = resultSet.getString( "state" );
                    int userID = resultSet.getInt( "user_id" );
                    movies.add(new Task( name,state,userID  ));
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return  movies;
    }

    public void updateTaskByID(Task task, int id){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(MariaDBConstant.DB_URL, MariaDBConstant.user, MariaDBConstant.pass);
            if (conn != null) {
                String query = "UPDATE  task SET name = ?, state = ?, user_id = ?, WHERE id = ?" ;
                PreparedStatement preparedStatement = conn.prepareStatement( query );
                preparedStatement.setString( 1,task.getName() );
                preparedStatement.setString( 2,task.getState() );
                preparedStatement.setInt( 2,task.getUserID() );
                preparedStatement.setInt( 3, id);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void deleteTaskByID( int id){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(MariaDBConstant.DB_URL, MariaDBConstant.user, MariaDBConstant.pass);
            if (conn != null) {
                String query = "DELETE FROM task  WHERE id = ?" ;
                PreparedStatement preparedStatement = conn.prepareStatement( query );
                preparedStatement.setInt( 1, id);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }




}
