package com.mateo;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
//import java.util.Arrays;

  
//"/Users/mateuszosinski/Desktop/Java/Projects/src/com/mateo/data.txt"

public class FileHandling {
    public static void Reader(String path){
        try{
            File file = new File(path);
            System.out.println("Does file exits? FileHandling.Reader() -> " + file.exists());
            Scanner scanner = new Scanner(file);
            while(scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
            scanner.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    public static void Writer(String path, String toFile){
        try{
            File file = new File(path);
            System.out.println("Does file exists? FileHandling.Writer() -> " + file.exists());
            FileWriter writer = new FileWriter(file.getAbsoluteFile(), true);
            writer.write(toFile + "\n");
            writer.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    public static void ReaderLogin(String path, String clientID, String password){
        try{
            boolean flag = false;
            File file = new File(path);
            Scanner scanner = new Scanner(file);
            while(scanner.hasNext()){
                String line = scanner.nextLine();
                String[] splited = line.split(";");
                //String[] current = Arrays.copyOfRange(splited, 0, 2);
                //System.out.println("FileHandling.ReaderLogin() -> ");
                //System.out.println(splited[0] + " " + splited[1]);
                String sClientID = (String)splited[0], sPassoword = splited[1];
                System.out.println(sClientID + " " + clientID + " " + sPassoword + " " + password);
                if(clientID == sClientID){
                    System.out.println("Founded! " + clientID);
                    flag = true;
                    if(password == sPassoword){
                        System.out.println("Welcome in the system, " + splited[2].toUpperCase() + splited[3].toUpperCase());
                    }
                }
            }
            if(!flag){
                System.out.println("Given ClientID was not found in the database.");
            }
            scanner.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
