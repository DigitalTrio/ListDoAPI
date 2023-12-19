package com.digitaltrio.listdoapi.data.exceptions;

import java.util.List;

public class FalsePasswordException extends RuntimeException {

    public FalsePasswordException() {
        super("Falsches Passwort");
    }
}
