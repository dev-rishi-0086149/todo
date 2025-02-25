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
    
<<<<<<< HEAD
    @ExceptionHandler(ResourceAlreadyExistException.class)
    public ResponseEntity<BaseResponseVO> handleResourceAlreadyExistException(ResourceAlreadyExistException e){
    	BaseResponseVO response = new BaseResponseVO();
    	ResponseStatusVO status = StatusUtil.getStatus("false");
    	response.setStatus(status);
    	response.setResponse(e.getMessage());
    	
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response); //409
    }
    
=======
    @ExceptionHandler(ResourceAlreadyExistException .class)
    public ResponseEntity<String> handleResourceAlreadyExist(ResourceAlreadyExistException e){
    	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
>>>>>>> 5c3565d0f3b448a4598c6a2e83b2947e834eb347
	
    // Handle general exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception e) {
    	System.out.println("inside general validation handler ");
    	return new ResponseEntity<>("An error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
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
    
    
   
    
    
}
