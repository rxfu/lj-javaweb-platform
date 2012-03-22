package com.pl.exception;

public class PlException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public PlException(){
		super();
	}
	public PlException(String message){
		super(message);
	}
	public PlException(String message, Throwable cause){
		super(message,cause);
	}
	public PlException(Throwable cause){
		super(cause);
	}

}
