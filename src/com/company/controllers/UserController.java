package com.company.controllers;

import com.company.objects.User;
import com.company.services.UserService;

import java.util.Scanner;

public class UserController {
    private  UserService userService = UserService.getInstance();



    public void  initializeAndCreateUser(){
        Scanner scanner =  new Scanner( System.in );
        System.out.println( "Please print Name SureName " );
        String name = scanner.nextLine();
        String sureName = scanner.nextLine();
        User user = new User( name, sureName );
        userService.createUser(user);
        System.out.println("Added");

    }



    public  void printAllUsers(){
        Scanner scanner = new Scanner( System.in );
        System.out.println("Please print ID");
        int input = scanner.nextInt();
        User user = new User( input );
        userService.printUserByID();
    }


    public   void updateUserByID(){
        System.out.println("Please print ID");

        Scanner scanner = new Scanner( System.in );
        String newName = scanner.nextLine();
        String newSureName = scanner.nextLine();
        int id = scanner.nextInt();
        User user = new User( newName, newSureName);
        userService.updateUserByID( user,id );
        System.out.println("Updated");


    }


    public  void deleteUserByID(){
        System.out.println("Please print ID");

        Scanner scanner = new Scanner( System.in );
        int id = scanner.nextInt();
        userService.deleteUserByID( id );
        System.out.println("Deleted");

    }
}
