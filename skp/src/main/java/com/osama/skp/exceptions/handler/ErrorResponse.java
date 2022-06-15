package com.osama.skp.exceptions.handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ErrorResponse {
      private HttpStatus code;
     private String message;


}
