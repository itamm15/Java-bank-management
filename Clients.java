package com.mateo;

public class Clients{
    private String name;
    private String surname;
    private String ClientID;
    private String password;
    private int money;

    public Clients(String _name, String _surname, String _ClientID, int _money, String _password){
        this.name = _name;
        this.surname = _surname;
        this.ClientID = _ClientID;
        this.money = _money;
        this.password = _password;
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

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }
}   
