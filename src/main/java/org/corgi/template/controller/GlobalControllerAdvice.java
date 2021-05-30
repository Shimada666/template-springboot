package org.corgi.template.controller;

import org.corgi.template.util.response.WebResponse;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

@ControllerAdvice
public class GlobalControllerAdvice {
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public WebResponse<Error> handleConstraintViolationException(ConstraintViolationException e) {
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        for (ConstraintViolation<?> item : violations) {
            return WebResponse.buildError(10001, item.getPropertyPath() + ": " + item.getMessage());
        }
        return WebResponse.buildError(10001, e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public WebResponse<Error> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        FieldError err = e.getBindingResult().getFieldError();
        if (err != null) {
            return WebResponse.buildError(10001, err.getField() + ": " + err.getDefaultMessage());
        }
        return WebResponse.buildError(10001, e.getMessage());
    }

    @ExceptionHandler(BindException.class)
    @ResponseBody
    public WebResponse<Error> handleBindException(BindException e) {
        FieldError err = e.getBindingResult().getFieldError();
        if (err != null) {
            return WebResponse.buildError(10001, err.getField() + ": " + err.getDefaultMessage());
        }
        return WebResponse.buildError(10001, e.getMessage());
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseBody
    public WebResponse<Error> handleMissingServletRequestParameterException(HttpServletRequest request, MissingServletRequestParameterException e) {
        return WebResponse.buildError(10001, request.getRequestURI() + ": " + e.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public WebResponse<Error> jsonErrorHandler(HttpServletRequest req, Exception e) {
        String msg = e.getMessage();
        int errCode = 10001;
        return WebResponse.buildError(errCode, msg);
    }
}
