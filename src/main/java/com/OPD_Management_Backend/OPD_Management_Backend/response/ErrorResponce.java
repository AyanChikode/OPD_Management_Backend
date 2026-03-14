package com.OPD_Management_Backend.OPD_Management_Backend.response;



import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponce {

    private int statusCode;
    private String message;
    private LocalDateTime timestamp;
}