package com.mateo;

public class Employees extends Bank{
    private String name;
    private String surname;
    private String ID;
    private String phoneNumber;
    private Position jobPosition;
    private String password;

    public Employees(String _place, String _postalCode, int _size, String _name, String _surname, String _ID, String _phoneNumber, Position _jobPosition, String _password){
        super("default", "default", 0);
        this.name = _name;
        this.surname = _surname;
        this.ID = _ID;
        this.phoneNumber = _phoneNumber;
        this.jobPosition = _jobPosition;
        this.password = _password;
    }     

    public Employees(){
        super();
    }                                         

    public static String toFile(Employees employee){
        String toFile = employee.getID() + ';' + employee.getPassword() + ';' + employee.getName() + ';' + employee.getSurname() + ';' + employee.getPhoneNumber() + ';' + employee.getThisPosition() + ';' + employee.getPlace() + ';' + employee.getPostalCode() + ';' + employee.getSize();
        return toFile;
    }

    public String getThisPosition(){
        return this.jobPosition.getPosition();
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

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Position getJobPosition() {
        return jobPosition;
    }

    public Position setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    public String getPassword(){
        return password;
    }
    
    public void setPassword(String _password){
        this.password = _password;
    }
}
