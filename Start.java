package com.mateo;

import java.io.File;
import java.util.Scanner;


public class Start {
    public static boolean state = false;
    public static boolean ifAdmin = false;
    public static void Start(){

        //This client is like main character - I am going to assign values from login and creation of user
        //right over to him

        Clients clientM = new Clients();
        ClientsService clientService = new ClientsService();

        Bank bank = new Bank();

        Employees employee = new Employees();
        EmployeesService employeeService = new EmployeesService();

        ClientMenu.startSwitch(clientM, clientService, bank, employee, employeeService);
        //System.out.println("After loggin/creating account : ");
        //clientService.printData(clientM);

        if(state){

            //There will be displayed three menu versions 
            //First for admin
            //Second for employees
            //Third for clients

            if(ifAdmin){
                AdminMenu.adminMenu(employeeService);
            }else{
                ClientMenu.clientMenu(clientM);
            }
        }
        //System.out.println("This is the client's information kept in the list !");
        //clientService.printDataFromList(clientService.clientList);
    }
}
