package com.mateo;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class ClientsService {
    public static List<Clients> clientList = new ArrayList<Clients>();
    Clients createUser(){
        Scanner scanner = new Scanner(System.in);
        String name, surname, ClientID, password;
        int money;
        System.out.println("Provide user name ");
        name = scanner.nextLine();
        System.out.println("Provide user surname ");
        surname = scanner.nextLine();
        //ClientID will be given randomly
        //ClientID regex = 4[0-9]6[A-Z]1[special_char];
        ClientID = randomClientID();
        System.out.println("Provide amount of money ");
        money = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Provide password ");
        password = scanner.nextLine();
        Clients client = new Clients(name, surname, ClientID, money, password);
        clientList.add(client);
        return client;
    }

    public static void login(boolean state){
        Scanner scanner = new Scanner(System.in);
        String  path = "/Users/mateuszosinski/Desktop/Java/Projects/src/com/mateo/users.txt";
        String clientID, password;
        System.out.println("Provide ClientID ");
        clientID = scanner.nextLine();
        System.out.println("Provide password ");
        password = scanner.nextLine();
        FileHandling.ReaderLogin(path, clientID, password, state, clientList);
    }

    public static void printDataFromList(){
        // Iterator<Object> itr = cList.iterator();
        // while(itr.hasNext()){
        //     System.out.println(itr.next());
        // }
        for(int i = 0;i<clientList.size();i++){
            System.out.println("\nYour name and surname: " + clientList.get(i).getName() + " " + clientList.get(i).getSurname() + ".\nYour bank account status: " +
                               clientList.get(i).getMoney() + ".\nYour password: " + clientList.get(i).getPassword());
        }
        
    }

    public static void printData(Clients client){
        System.out.println(client.getName() + " " + client.getSurname() + " " + client.getMoney() + " " + client.getPassword() + " " + client.getClientID());
    }
    public static String randomClientID(){
        //33-47 - range of special chars
        Random rand = new Random();
        String clientID = "";
        char startChar = 'a';
        final int upperBoundNum = 9, charRange = 26, lowerBoundSpecial = 33, upperBoundSpecial = 47;
        for(int i = 0;i<4;i++){
            int tmp = rand.nextInt(upperBoundNum);
            clientID += tmp;
        }
        for(int i = 0;i<6;i++){
            int tmp = rand.nextInt(charRange);
            clientID += (char)(startChar + tmp);
        }
        for(int i = 0;i<1;i++){
            int tmp = lowerBoundSpecial + (int)(Math.random() * ((upperBoundSpecial - lowerBoundSpecial) + 1));
            char covertedTmp = (char)tmp;
            clientID += covertedTmp;
        }
        return clientID;
    }
}
