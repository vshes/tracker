package io.shesh.tracker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by shesh on 5/29/17.
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {

    public BadRequestException(String msg, Throwable t){
        super(msg,t);

    }

    public BadRequestException(String msg){
        super(msg);
    }

}
