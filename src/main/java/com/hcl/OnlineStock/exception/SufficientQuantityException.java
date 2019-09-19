package com.hcl.OnlineStock.exception;

public class SufficientQuantityException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public SufficientQuantityException(String message)
	{
		super(message);
	}

}
