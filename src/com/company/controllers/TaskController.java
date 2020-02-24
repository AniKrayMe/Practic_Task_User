package com.company.controllers;

import com.company.objects.Task;
import com.company.services.TaskService;

import java.util.Scanner;

public class TaskController {
    private TaskService taskService = TaskService.getInstance();



  public   void  initializeAndCreateTask(){
        Scanner scanner =  new Scanner( System.in );
        System.out.println( "Please print Name, State and UserID" );
        String name = scanner.nextLine();
        String state = scanner.nextLine();
        int userID = scanner.nextInt();
        Task task = new Task( name, state, userID );
        taskService.createTask(task);
      System.out.println("Added");
    }



    public void printAllTasks(){
        taskService.showTasks();
    }


    public  void updateTaskByID(){
        System.out.println("Please print ID");
        Scanner scanner = new Scanner( System.in );
        String newName = scanner.nextLine();
        String newState = scanner.nextLine();
        int newUserID = scanner.nextInt();
        int id = scanner.nextInt();
        Task task = new Task( newName, newState,newUserID);
        taskService.updateTaskByID( task,id );
        System.out.println("Updated");

    }

    public void deleteTaskByID(){
        System.out.println("Please print ID");
        Scanner scanner = new Scanner( System.in );
        int id = scanner.nextInt();
        taskService.deleteTaskByID( id );
        System.out.println("Deleted");

    }
}
