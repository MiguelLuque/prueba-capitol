package com.miguel.prueba.capitol.exceptions;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class ExceptionController {

	// Se lanzará una excepción contralada cuando reciba otra que no haya sido capturada por otro de los métodos
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<GenericErrorResponse> genericException(Exception e) {

		GenericErrorResponse error = new GenericErrorResponse("Internal server error", e.getMessage());

		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);

	}
	
	// Lanzará una excepción cuando no logre recuperar un price 

	@ExceptionHandler(value = NoSuchElementException.class)
	public ResponseEntity<GenericErrorResponse> priceNotFoundException(NoSuchElementException e) {

		GenericErrorResponse error = new GenericErrorResponse("Price not found", e.getMessage());

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

	}
	
	// Lanzará una excepción cuando no se informen los parámetros correctamente

	@ExceptionHandler({MissingServletRequestParameterException.class, MethodArgumentTypeMismatchException.class })
	public ResponseEntity<GenericErrorResponse> badRequestException(Exception e) {

		GenericErrorResponse error = new GenericErrorResponse("Bad request", e.getMessage());

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

	}

}
