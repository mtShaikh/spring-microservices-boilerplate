package com.taha.boilerplate.user.advice;


import com.taha.boilerplate.user.common.ErrorConstants;
import com.taha.boilerplate.user.domain.User;
import com.taha.boilerplate.user.dto.Meta;
import com.taha.boilerplate.user.dto.ServiceResponse;
import com.taha.boilerplate.user.exception.AbstractUserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ValidationControllerExceptionHandler {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ServiceResponse<Object> validationHandler(MethodArgumentNotValidException e){
        log.debug(e.toString());

        String errorMessage = e.getBindingResult().getFieldError().getDefaultMessage();

        return new ServiceResponse<>(new User(), new Meta(errorMessage, String.valueOf(HttpStatus.BAD_REQUEST), errorMessage));
    }

    @ExceptionHandler({AbstractUserException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ServiceResponse<User> userHandler(AbstractUserException e) {

        log.debug(e.toString());

        ServiceResponse<User> retUser = null;
        switch (e.getClass().getSimpleName()) {
            case "UserAlreadyExistsException":
                retUser = new ServiceResponse<>(new User(),
                        new Meta(ErrorConstants.ERROR_USER_ALREADY_EXISTS, String.valueOf(HttpStatus.CONFLICT), ErrorConstants.ERROR_USER_ALREADY_EXISTS));
                break;
            case "IncorrectEmailOrPasswordException":
                retUser = new ServiceResponse<>(new User(),
                        new Meta(ErrorConstants.ERROR_INCORRECT_EMAIL_OR_PASSWORD, String.valueOf(HttpStatus.BAD_REQUEST), ErrorConstants.ERROR_INCORRECT_EMAIL_OR_PASSWORD));
                break;
        }
        return retUser;
    }

}