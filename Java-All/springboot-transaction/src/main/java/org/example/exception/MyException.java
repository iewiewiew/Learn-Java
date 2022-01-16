package org.example.exception;

/**
 * @author weimenghua
 * @time 2023-01-14 15:09
 * @description
 */
public class MyException extends RuntimeException{
    public MyException(){
        super();
    }

    public MyException(String runtime){
        super(runtime);
    }
}
