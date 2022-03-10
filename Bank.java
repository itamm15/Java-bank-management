package com.mateo;

public class Bank {
    private String place;
    private String postalCode;
    private int size;

    public Bank(){
        
    }

    public Bank(String _place, String _postalCode, int _size){
        this.place = _place;
        this.postalCode = _postalCode;
        this.size = _size;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
