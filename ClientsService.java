package com.mateo;

import java.util.Scanner;

public class ClientsService {
    Clients createUser(){
        Scanner scanner = new Scanner(System.in);
        String name, surname, ClientID;
        int money;
        System.out.println("Provide user name ");
        name = scanner.nextLine();
        System.out.println("Provide user surname ");
        surname = scanner.nextLine();
        //ClientID will be given randomly
        ClientID = "00000";
        System.out.println("Provide amount of money ");
        money = scanner.nextInt();
        Clients client = new Clients(name, surname, ClientID, money);
        return client;
    }
    public static void printData(Clients client){
        System.out.println(client.getName() + " " + client.getSurname() + " " + client.getMoney());
    }
}
