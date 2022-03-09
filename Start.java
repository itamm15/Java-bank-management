package com.mateo;

import java.util.Scanner;


public class Start {
    public static boolean state = false;
    public static void Start(){

        //This client is like main character - I am going to assign values from login and creation of user
        //right over to him

        Clients clientM = new Clients();
        
        ClientsService clientService = new ClientsService();
        System.out.println("Welcome in our Bank! Please select one of the given choices.\n" +
                           "1. Login into your account\n" +
                           "2. Create new account \n");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        switch(choice){
            case "1":{
                clientService.login(Start.state);
                clientService.assignToMain(clientM);
                //System.out.println(state + " -> state, if user is logged");
                break;
            }
            case "2":{
                Clients newClient = clientService.createUser();
                FileHandling.Writer("/Users/mateuszosinski/Desktop/Java/Projects/src/com/mateo/users.txt", Clients.toFile(newClient));
                state = true;
                clientService.assignToMain(clientM);
                //clientService.printDataFromList();
                break;
            }
            default:{
                System.out.println("I could not find given clientID, please try again later.");
            }
        }
        //System.out.println("After loggin/creating account : ");
        //clientService.printData(clientM);

        if(state){
            System.out.println("Welcome in the main program! Please, select one of given options.\n" + 
                                "1. Check account details\n" + 
                                "2. Check bank account balance\n" + 
                                "3. Withdraw money\n" + 
                                "4. Deposit money\n" + 
                                "5. Change password\n" + 
                                "6. Exit");
            while(true){
                String userDecision = scanner.nextLine();
                switch(userDecision){
                case "1":{
                    //clientService.printDataFromList();
                    clientM.userInfo();
                    break;
                }
                case "2":{
                    clientM.printAccountBalance();
                    break;
                }
                case "3":{
                    clientM.withdrawMoney();
                    break;
                }
                case "4":{
                    clientM.depositMoney(); 
                    break;
                }
                case "5":{
                    Scanner scannerPassword = new Scanner(System.in);
                    System.out.println("Please, provide new password: ");
                    String scannPass = scannerPassword.nextLine();
                    clientM.setPassword(scannPass);
                    break;
                }
                case "6":{
                    FileHandling.updateData(clientM);
                    FileHandling.clearConsole();
                    System.exit(0);
                }
                default:{
                    System.out.println("Provided choice is unknown. Please, provide it again.");
                    break;
                }
            }
            System.out.println("Please, select one of given options.\n" + 
                                "1. Check account details\n" + 
                                "2. Check bank account balance\n" + 
                                "3. Withdraw money\n" + 
                                "4. Deposit money\n" + 
                                "5. Change password\n" + 
                                "6. Exit");
            }
            
        }
        //System.out.println("This is the client's information kept in the list !");
        //clientService.printDataFromList(clientService.clientList);
    }
}
