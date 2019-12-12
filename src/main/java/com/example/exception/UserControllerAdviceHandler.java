package com.example.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.model.ErrorDto;
import com.example.model.FormFieldDto;

@ControllerAdvice
public class UserControllerAdviceHandler {

	@ExceptionHandler({ MethodArgumentNotValidException.class })
	public ResponseEntity<ErrorDto> handleIllegalArgumentException(MethodArgumentNotValidException exception) {
		BindingResult bindingResult = exception.getBindingResult();
		List<FieldError> fieldErrors = bindingResult.getFieldErrors();
		List<FormFieldDto> formFields = new ArrayList<>();
		for (FieldError fieldError : fieldErrors) {
			formFields.add(new FormFieldDto(fieldError.getField(), fieldError.getDefaultMessage()));
			System.out.println(fieldError.getField() + " - > " + fieldError.getDefaultMessage());
		}

		ErrorDto errorDto = new ErrorDto("invald arguments", LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(),
				formFields);
		return new ResponseEntity<ErrorDto>(errorDto, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler({ IllegalArgumentException.class })
	public ResponseEntity<ErrorDto> handleIllegalArgumentException(IllegalArgumentException illegalArgumentException) {
		ErrorDto errorDto = new ErrorDto(illegalArgumentException.getMessage(), LocalDateTime.now(),
				HttpStatus.BAD_REQUEST.value(), null);
		return new ResponseEntity<ErrorDto>(errorDto, HttpStatus.BAD_REQUEST);
	}

}
