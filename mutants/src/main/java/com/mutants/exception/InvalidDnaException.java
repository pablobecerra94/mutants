package com.mutants.exception;

/**
 * Exception used for DNA validation
 * 
 * @author Pablo
 *
 */
public class InvalidDnaException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidDnaException(String message) {
		super(message);
	}

}
