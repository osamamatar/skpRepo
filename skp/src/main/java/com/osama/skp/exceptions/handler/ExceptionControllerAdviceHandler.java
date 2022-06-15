package com.osama.skp.exceptions.handler;

import com.osama.skp.exceptions.AbstractEntityNotFound;
import com.osama.skp.exceptions.AbstractGlopalException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;


@ControllerAdvice
public class ExceptionControllerAdviceHandler {

    @ExceptionHandler({AbstractGlopalException.class})
  public ResponseEntity<ErrorResponse>handelGlopalException(AbstractGlopalException e){
        ErrorResponse errorResponse=new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
       return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

    @ExceptionHandler({AbstractEntityNotFound.class})
    public ResponseEntity<ErrorResponse> handleNotFoundException(AbstractEntityNotFound e) {
        ErrorResponse errorResponse=new ErrorResponse(HttpStatus.BAD_REQUEST,e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
    @ExceptionHandler({Exception.class})
    protected ResponseEntity handleException(Exception e) {
        return ResponseEntity
               .internalServerError()
                .body("Exception occur inside API " + e);
    }
}
