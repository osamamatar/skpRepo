package com.osama.skp.dto;

import lombok.Data;

@Data
public class MessageRequest {

    private String destination;
    private String message;
}
