package com.mateo;

import java.util.ArrayList;

public class Position {
    private String positon;
    public Position(String _position){
        this.positon = _position;
    }

    public String getPosition(){
        return positon;
    }
    public void setPosition(String _newPosition){
        this.positon = _newPosition;
    }
}
