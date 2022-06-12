package com.oma.b2b.dto;

import lombok.Data;

@Data
public class MessageRequest {

    private String destination;
    private String message;
}
