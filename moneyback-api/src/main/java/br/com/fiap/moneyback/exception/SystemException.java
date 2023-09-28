package br.com.fiap.moneyback.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "stackTrace", "localizedMessage", "suppressed", "cause" })
public class SystemException extends RuntimeException{


	public SystemException(Throwable t, String message, String args) {
		super(String.format(message, args), t);
	}
	
	public SystemException(String message, String ...args) {
		super(String.format(message, args));
	}
	
}
