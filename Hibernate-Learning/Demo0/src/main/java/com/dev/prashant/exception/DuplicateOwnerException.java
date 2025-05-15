package com.dev.prashant.exception;

/**
 * @author devPrashatKumar
 *
 */
public class DuplicateOwnerException extends Exception {
	private static final long serialVersionUID = 1L;

	public DuplicateOwnerException(String message) {
		super(message);
	}
}
