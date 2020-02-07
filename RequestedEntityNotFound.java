package io.sonali.store;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_FOUND)
public class RequestedEntityNotFound  extends RuntimeException 
{
  public RequestedEntityNotFound(String message) 
  {
    super(message);
  }
}