package com.mateo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


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
}
