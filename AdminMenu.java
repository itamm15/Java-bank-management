package com.mateo;

import java.util.Scanner;

public class AdminMenu {
    public static void adminMenu(EmployeesService employeeService){
        Scanner scanner = new Scanner(System.in);
        String choiceAdmin;
                System.out.println("Provided one of the following options " + 
                                   "\n1. Table of Clients " +
                                   "\n2. Table of Employees " +
                                   "\n3. Add Employee " +
                                   "\n4. Remove Employee " +
                                   "\n5. Remove Client " + 
                                   "\n6. Sum of Client deposited money " +
                                   "\n7. Exit");
                choiceAdmin = scanner.nextLine();
                while(true){
                    switch(choiceAdmin){
                        case "1":{
                            FileHandling.Reader("/Users/mateuszosinski/Desktop/Java/Projects/src/com/mateo/users.txt");
                            break;
                        }
                        case "2":{
                            FileHandling.Reader("/Users/mateuszosinski/Desktop/Java/Projects/src/com/mateo/employees.txt");
                            break;
                        }
                        case "3":{  
                            Employees newEmployee = employeeService.createEmployee();
                            break;
                        }
                        case "4":{
    
                        }
                        case "5":{
    
                        }
                        case "6":{
    
                        }
                        case "7":{
                            FileHandling.clearConsole();
                            System.exit(0);
                            break;
                        }
                        default:{
                            System.out.println("Given choice was not recognized. Please try again.");
                            break;
                        }
                    }
                    System.out.println("Provided one of the following options " + 
                                        "\n1. Table of Clients " +
                                        "\n2. Table of Employees " +
                                        "\n3. Add Employee " +
                                        "\n4. Remove Employee " +
                                        "\n5. Remove Client " + 
                                        "\n6. Sum of Client deposited money " + 
                                        "\n7. Exit");
                    choiceAdmin = scanner.nextLine();
                }
    }
}
