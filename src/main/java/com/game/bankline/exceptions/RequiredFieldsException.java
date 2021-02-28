package com.game.bankline.exceptions;

public class RequiredFieldsException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public RequiredFieldsException(String msg){
        super(msg);
    }

    public RequiredFieldsException(String msg, Throwable cause){
        super(msg,cause);
    }

}
