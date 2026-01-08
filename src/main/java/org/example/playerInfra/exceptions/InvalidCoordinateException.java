package org.example.playerInfra.exceptions;

public class InvalidCoordinateException extends RuntimeException{

    public InvalidCoordinateException(String mensage){
        super(mensage);
    }

}
