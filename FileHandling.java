package com.mateo;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.List;
import java.util.Arrays;


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
            //System.out.println("Does file exists? FileHandling.Writer() -> " + file.exists());
            FileWriter writer = new FileWriter(file.getAbsoluteFile(), true);
            //System.out.println("I am here FilaHandling.Writer() - > " + toFile);
            writer.write(toFile + "\n");
            writer.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    public static void ReaderLogin(String path, String clientID, String password, boolean state, List <Clients>  clientList){
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
                if(clientID.equals(sClientID)){
                    //System.out.println("Found! " + clientID);
                    if(password.equals(sPassoword)){
                        flag = true; 
                        Start.state = true;
                        System.out.println("Welcome in the system, " + splited[2].toUpperCase() + " " + splited[3].toUpperCase());
                        clientList.add(new Clients(splited[2], splited[3], splited[0], Double.parseDouble(splited[4]), splited[1]));
                    }else{
                        System.out.println("Given password is not correct. Please, try again.");
                        System.exit(0);
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
    
    public final static void clearConsole(){
        try{
            final String os = System.getProperty("os.name");

            if(os.contains("Windows")){
                Runtime.getRuntime().exec("cls");
            }else{
                Runtime.getRuntime().exec("clear");
            }
        }
        catch(final Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    //Deleting/replacing old data with new one

    public static void updateData(Clients client){
        try{
            final String clientID = client.getClientID();
            System.out.println("FileHandling.updateData() -> ClientID = " + clientID);
            final String pathMain = "/Users/mateuszosinski/Desktop/Java/Projects/src/com/mateo/users.txt";
            final String pathTmp =  "/Users/mateuszosinski/Desktop/Java/Projects/src/com/mateo/data.txt";
            File file = new File(pathMain);
            File tmp = new File(pathTmp);
            FileWriter writerTmp = new FileWriter(tmp, false);        
            //search of given clientID;
            //the algorithm is going to take line by line, and it is going to search by first keyword (till it will find ';')
            //the complexity is linear
            //however, it just an .txt file, in next project I will operate on mysql services + spring
            Scanner scannerMain = new Scanner(file);
            while(scannerMain.hasNext()){
                String line = scannerMain.nextLine();
                String[] splitedLine = line.split(";");
                if(!(splitedLine[0].equals(clientID))){
                    System.out.println("this is the line -> " + line);
                    writerTmp.write(line + "\n");
                }else{
                    writerTmp.write(Clients.toFile(client) + "\n");
                }
            }
            //Right now data.txt contains updated info
            //So users.txt MUST be truncated, and info from data.txt needs to be transported
            FileWriter writerMain = new FileWriter(file, false);
            writerTmp.close();
            Scanner scannerTmp = new Scanner(tmp);
            while(scannerTmp.hasNext()){
                String line = scannerTmp.next();
                System.out.println("SCANNER " + line);
                writerMain.write(line+ "\n");
            }
            writerMain.close();
            scannerTmp.close();
            scannerMain.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }


}
