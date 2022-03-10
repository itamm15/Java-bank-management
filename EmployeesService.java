package com.mateo;

import java.util.Scanner;

public class EmployeesService {
    Employees createEmployee(){
        Scanner scanner = new Scanner(System.in);
        String name, surname, ID, phoneNumber, position, bank, password;
        System.out.println("Provide name ");
        name = scanner.nextLine();
        System.out.println("Provide surname ");
        surname = scanner.nextLine();
        System.out.println("Provide phone number ");
        phoneNumber = scanner.nextLine();
        System.out.println("Provide position ");
        position = scanner.nextLine();
        System.out.println("Provide password ");
        password = scanner.nextLine();
        //System.out.println("Provide the bank name ");
        //bank = scanner.nextLine();
        ID = "E021";
        Employees employee = new Employees("default", "default", 0, name, surname, ID, phoneNumber, new Position(position), password);
        //Employees employee = new Employees();
        FileHandling.Writer("/Users/mateuszosinski/Desktop/Java/Projects/src/com/mateo/employees.txt", Employees.toFile(employee));
        return employee;
    }



    public static void createID(){
        
    }
}
