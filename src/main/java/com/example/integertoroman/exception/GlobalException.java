package com.example.integertoroman.exception;


import com.example.integertoroman.response.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(OutOfBound.class)
    public ResponseEntity<ErrorResponseDto> handlerForFailedMailException(final OutOfBound ex){
        ErrorResponseDto errorResponse = new ErrorResponseDto();
        errorResponse.setHttpStatus(HttpStatus.BAD_REQUEST);
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setDebugMessage("Number cannot be greater than 4999");
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
}
}
