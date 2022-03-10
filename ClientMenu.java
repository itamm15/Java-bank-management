package com.mateo;

import java.util.Scanner;

public class ClientMenu{
    public static void clientMenu(Clients clientM){
        Scanner scanner = new Scanner(System.in);
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

    public static void startSwitch(Clients clientM, ClientsService clientService, Bank bank, Employees employee, EmployeesService employeeService){
        System.out.println("Welcome in our Bank! Please select one of the given choices.\n" +
                            "1. Login into your account\n" +
                            "2. Create new account \n");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        switch(choice){
        case "1":{
        String whoAmI, password;
        System.out.println("Provide your name ");
        whoAmI = scanner.nextLine();
        if(whoAmI.equals("admin")){
            System.out.println("Provide password ");
            password = scanner.nextLine();
                if(password.equals("admin")){
                    Start.state = true;
                    Start.ifAdmin = true;
                }else{
                    System.out.println("Given password does not match. Please, try again later");
                    System.exit(0);
                }
            }else{
                clientService.login(Start.state);
                clientService.assignToMain(clientM);
            }
            //System.out.println(state + " -> state, if user is logged");
            break;
        }
        case "2":{
            Clients newClient = clientService.createUser();
            FileHandling.Writer("/Users/mateuszosinski/Desktop/Java/Projects/src/com/mateo/users.txt", Clients.toFile(newClient));
            Start.state = true;
            clientService.assignToMain(clientM);
            //clientService.printDataFromList();
            break;
        }
        default:{
            System.out.println("I could not find given clientID, please try again later.");
        }
        }
    }

}