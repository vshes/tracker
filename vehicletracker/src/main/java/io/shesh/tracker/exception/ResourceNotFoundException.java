package io.shesh.tracker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by shesh on 5/29/17.
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException  extends RuntimeException {
    public ResourceNotFoundException(String msg, Throwable t){
        super(msg,t);

    }

    public ResourceNotFoundException(String msg){
        super(msg);
    }

}
