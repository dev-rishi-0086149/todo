package com.devrishi.todo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.devrishi.todo.contract.BaseResponseVO;
import com.devrishi.todo.contract.ResponseStatusVO;
import com.devrishi.todo.util.StatusUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
	

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<BaseResponseVO> handleResourceNotFound(ResourceNotFoundException e) {
    	BaseResponseVO response = new BaseResponseVO();
    	ResponseStatusVO status = StatusUtil.getStatus("false");
    	response.setStatus(status);
    	response.setResponse(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
    

    @ExceptionHandler(ResourceAlreadyExistException.class)
    public ResponseEntity<BaseResponseVO> handleResourceAlreadyExistException(ResourceAlreadyExistException e){
    	BaseResponseVO response = new BaseResponseVO();
    	ResponseStatusVO status = StatusUtil.getStatus("false");
    	response.setStatus(status);
    	response.setResponse(e.getMessage());
    	
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response); //409
    }
    

	
    // Handle general exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception e) {
    	System.out.println("inside general validation handler ");
    	System.out.println(Arrays.toString(e.getStackTrace()));
    	return new ResponseEntity<>("An error occurred: " + e.getMessage()+e.getClass(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BaseResponseVO> handleValidationException(MethodArgumentNotValidException e){
    	BaseResponseVO response = new BaseResponseVO();
    	
    	Map<String,String> errors = new HashMap<>();
    	e.getBindingResult().getAllErrors().forEach(error -> {
    		String fieldName = ((FieldError) error).getField();
    		String errorMessage = error.getDefaultMessage();
    		errors.put(fieldName, errorMessage);
    	});
    	ResponseStatusVO status = StatusUtil.getStatus("false");
    	response.setStatus(status);
    	response.setResponse(errors);
    	
    	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
    
    @ExceptionHandler(InvalidCredentialException.class)
    public ResponseEntity<BaseResponseVO> handleInvalidCredentialException(InvalidCredentialException e){
    	BaseResponseVO response = new BaseResponseVO();
    	response.setStatus(StatusUtil.getStatus("false"));
    	response.setResponse(e.getMessage());
    	return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }
    
   
    
    
}
