package com.digitaltrio.listdoapi.data.exceptions;

import java.util.List;

public class EmptyValuesException extends RuntimeException {

    private final List<String> emptyFields;

    public EmptyValuesException(List<String> emptyFields) {
        super("Empty values found: " + emptyFields);
        this.emptyFields = emptyFields;
    }

    public List<String> getEmptyFields() {
        return emptyFields;
    }
}