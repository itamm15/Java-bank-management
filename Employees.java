package com.mateo;

public class Employees extends Bank{
    private String name;
    private String surname;
    private String ID;
    private String phoneNumber;
    private String jobPosition;

    public Employees(String _place, String _postalCode, int _size, String _name, String _surname, String _ID, String _phoneNumber, String _jobPosition){
        super(_place, _postalCode, _size);
        this.name = _name;
        this.surname = _surname;
        this.ID = _ID;
        this.phoneNumber = _phoneNumber;
        this.jobPosition = _jobPosition;
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

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }
}
