package com.library.kodillalibrary.controller.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalHttpErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(TitleNotFoundException.class)
    public ResponseEntity<Object> handleTitleNotFoundException(TitleNotFoundException exception){
        return new ResponseEntity<>("Title with given id doesn't exist", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ExemplarNotFoundException.class)
    public ResponseEntity<Object> handleExemplarNotFoundException(ExemplarNotFoundException exception){
        return new ResponseEntity<>("Exemplar with given id doesn't exist", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ReaderNotFoundException.class)
    public ResponseEntity<Object> handleReaderNotFoundException(ReaderNotFoundException exception){
        return new ResponseEntity<>("Reader with given id doesn't exist", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RentedExemplarException.class)
    public ResponseEntity<Object> handleRentedExemplarException(RentedExemplarException exception){
        return new ResponseEntity<>("This exemplar is rented", HttpStatus.BAD_REQUEST);
    }


}