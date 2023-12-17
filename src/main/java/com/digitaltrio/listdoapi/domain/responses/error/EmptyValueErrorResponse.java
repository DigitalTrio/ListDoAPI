package com.digitaltrio.listdoapi.domain.responses.error;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class EmptyValueErrorResponse<T> {

    public List<String> checkForEmptyValues(T object) {
        List<String> emptyFields = getEmptyFields(object);

        if (!emptyFields.isEmpty()) {
            return emptyFields;
        }

        return new ArrayList<>();
    }

    private List<String> getEmptyFields(T object) {
        List<String> emptyFields = new ArrayList<>();
        Field[] fields = object.getClass().getDeclaredFields();

        for (Field field : fields) {
            try {
                String fieldName = field.getName();
                String getterMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);

                Method getterMethod = object.getClass().getMethod(getterMethodName);
                Object value = getterMethod.invoke(object);

                if (value == null) {
                    emptyFields.add(fieldName);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        return emptyFields;
    }
}
