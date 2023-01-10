package ru.evgenkov.cloudserviceapi.exeptions;

public class InputDataException extends RuntimeException{
    public InputDataException(String msg){
        super(msg);
    }
}
