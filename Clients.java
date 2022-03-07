package com.mateo;

import java.util.Scanner;

public class Clients{
    private String name;
    private String surname;
    private String ClientID;
    private String password;
    private double money;

    public Clients(){
        this("", "", "", 0.0, "");
    }

    public Clients(String _name, String _surname, String _ClientID, double _money, String _password){
        this.name = _name;
        this.surname = _surname;
        this.ClientID = _ClientID;
        this.money = _money;
        this.password = _password;
    }

    public void printAccountBalance(){
        System.out.println("The account balance is " + getMoney());
    }

    public void withdrawMoney(){
        double balance = getMoney();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Provide amount to withdraw \n");
        double amountToWithdraw = scanner.nextDouble();
        System.out.println("Amount before withdrawal " + getMoney());
        if(balance >= amountToWithdraw){
            setMoney(balance - amountToWithdraw);
            System.out.println("Given amount has been withdrawn = " + amountToWithdraw +
                               ". Your account balance is " + getMoney());
        }
        
    }

    public static String toFile(Clients client){
        //ClientID;password;name;surname;money
        String toFile = client.getClientID() + ';' + client.getPassword() + ';' + client.getName() + ';' + client.getSurname() + ';' + client.getMoney();
        return toFile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getClientID() {
        return ClientID;
    }

    public void setClientID(String clientID) {
        ClientID = clientID;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double d) {
        this.money = d;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }
}   
