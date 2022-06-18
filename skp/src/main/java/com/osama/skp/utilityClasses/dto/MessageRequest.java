package com.osama.skp.utilityClasses.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor@NoArgsConstructor
public class MessageRequest {

    private String destination;
    private String message;
    private String subject;


}
