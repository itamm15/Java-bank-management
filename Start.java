package com.mateo;

import java.util.Scanner;

public class Start {
    static boolean state = false;
    public static void Start(){
        ClientsService clientService = new ClientsService();
        System.out.println("Welcome in our Bank! Please select one of the given choices.\n" +
                           "1. Login into your account\n" +
                           "2. Create new account\n");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        switch(choice){
            case "1":{
                clientService.login(state);
            }
            case "2":{
                Clients newClient = clientService.createUser();
                FileHandling.Writer("/Users/mateuszosinski/Desktop/Java/Projects/src/com/mateo/users.txt", Clients.toFile(newClient));
                state = true;
                //clientService.printDataFromList();
            }
        }
        if(state){
            System.out.println("Welcome in the main program!");
        }
        //System.out.println("This is the client's information kept in the list !");
        //clientService.printDataFromList(clientService.clientList);
    }
}
