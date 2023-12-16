package br.com.bruno.gestaovagas.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

// DTO - Data Transfer to Object
@Data
@AllArgsConstructor
public class ErrorMessageDTO {
    
    private String message;
    private String field;
    
}
