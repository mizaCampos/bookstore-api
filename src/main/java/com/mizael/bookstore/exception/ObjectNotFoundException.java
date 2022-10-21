package com.mizael.bookstore.exception;

public class ObjectNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ObjectNotFoundException(String arg0) {
        super(arg0);
    }

    public ObjectNotFoundException(Throwable arg0) {
        super(arg0);
    }

   
    
}
