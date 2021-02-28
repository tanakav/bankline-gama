package com.game.bankline.exceptions;

public class DuplicateKeyException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public DuplicateKeyException(String msg){
        super(msg);
    }

    public DuplicateKeyException(String msg, Throwable cause){
        super(msg,cause);
    }

}
