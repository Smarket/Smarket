package br.com.smarket.controller;

public class SmarketException extends Exception{  

	private static final long serialVersionUID = 1L;
	
	private String msgErro;
    
	public SmarketException(String msgErro){  
      super(msgErro);  
      this.msgErro = msgErro; 
    }  
	
	public SmarketException(String msgErro, Throwable causa){  
	      super(msgErro, new Exception(causa));  
	      this.msgErro = msgErro; 
	 }  
    
	public String getMessage(){  
      return msgErro;
    }  
  }  
