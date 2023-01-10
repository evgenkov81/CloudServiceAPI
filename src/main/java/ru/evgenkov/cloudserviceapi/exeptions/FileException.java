package ru.evgenkov.cloudserviceapi.exeptions;

public class FileException extends RuntimeException{
    public FileException(String msg){
        super(msg);
    }
}
