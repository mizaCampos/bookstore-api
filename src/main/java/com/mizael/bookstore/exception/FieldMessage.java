package com.mizael.bookstore.exception;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class FieldMessage implements Serializable{

    private static final long serialVersionUID = 1L;

    private String fieldName;
    private String message;

    public FieldMessage(){}

    public FieldMessage(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }

    

}