package com.hcl.OnlineStock.exception;




public class StockNotAvaliableException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public  StockNotAvaliableException(String message)
	{
		super(message);
	}
	

}
