package com.mizael.bookstore.exception;
import java.util.ArrayList;
import java.util.List;

import com.mizael.bookstore.resourcesExceptions.StandardError;

import lombok.Getter;
import lombok.Setter;;

@Getter @Setter

public class ValidationError extends StandardError{

    private List<FieldMessage> errors = new ArrayList<>();

    public ValidationError() {
    }

    public ValidationError(Long timestamp, Integer status, String error) {
        super(timestamp, status, error);
    }
    
    public void addErrors(String fieldName, String message){
        this.errors.add(new FieldMessage(fieldName, message));
    }
    
}
