package ru.evgenkov.cloudserviceapi.exeptions;

public class UnauthorizedException extends RuntimeException{
    public UnauthorizedException (String msg){
        super(msg);
    }
}
