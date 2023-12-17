package com.digitaltrio.listdoapi.domain.aspects;

import com.digitaltrio.listdoapi.data.annotations.CheckForEmptyValues;
import com.digitaltrio.listdoapi.data.exceptions.EmptyValuesException;
import com.digitaltrio.listdoapi.domain.responses.error.EmptyValueErrorResponse;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class CheckForEmptyValuesAspect {

    @Before("@annotation(checkForEmptyValues)")
    public void checkForEmptyValues(JoinPoint joinPoint, CheckForEmptyValues checkForEmptyValues) {
        Object[] methodArgs = joinPoint.getArgs();

        if (methodArgs.length > 0) {
            Object instance = methodArgs[0];

            try {
                EmptyValueErrorResponse<Object> emptyErrorResponse = new EmptyValueErrorResponse<>();
                List<String> list = emptyErrorResponse.checkForEmptyValues(instance);

                if (!list.isEmpty()) {
                    throw new EmptyValuesException(list);
                }
            } catch (Exception e) {
                throw new RuntimeException("Error checking for empty values", e);
            }
        }
    }

}