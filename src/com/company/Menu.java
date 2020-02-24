package com.company;

import com.company.controllers.TaskController;
import com.company.controllers.UserController;

import java.util.Scanner;

public class Menu {
    private TaskController taskController = new TaskController();
    private UserController userController = new UserController();
    public void printMenu(){
        Scanner scanner = new Scanner( System.in );
        System.out.println("-----------------MENU-----------------");
        System.out.println("---------pres 1 for User CRUD---------");
        System.out.println("---------pres 1 for Task CRUD---------");
        int num = scanner.nextInt();
        if (num == 1) {

            System.out.println( "--------------1  CREATE  1--------------" );
            System.out.println( "------------2  PRINT ALL  2------------" );
            System.out.println( "--------------3  UPDATE  3-------------" );
            System.out.println( "--------------4  DELETE  4-------------" );
            int input = scanner.nextInt();
            switch (input) {
                case 1:
                    userController.initializeAndCreateUser();
                    break;
                case 2:
                    userController.printAllUsers();
                    break;
                case 3:
                    userController.updateUserByID();
                    break;
                case 4:
                    userController.deleteUserByID();
                    break;
                default:
                    System.out.println( "INCORRECT INPUT" );
            }
        }

        if (num == 2){

        System.out.println("--------------1  CREATE  1--------------");
        System.out.println("------------2  PRINT ALL  2------------");
        System.out.println("--------------3  UPDATE  3-------------");
        System.out.println("--------------4  DELETE  4-------------");
        int input2 = scanner.nextInt();
        String test = scanner.nextLine();
        switch (input2) {
            case (1):
                taskController.initializeAndCreateTask();
                break;
            case (2):
                taskController.printAllTasks();
                break;
            case (3):
                taskController.updateTaskByID();
                break;
            case (4):
                taskController.deleteTaskByID();
                break;
            default:
                System.out.println( "INCORRECT INPUT" );
          }
        }
        else {
            System.out.println("INCORRECT INPUT");
        }

    }
}
