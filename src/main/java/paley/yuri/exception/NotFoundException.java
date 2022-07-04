package paley.yuri.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
  public NotFoundException(String message, Object... args) {
    super(String.format(message, args));
  }
}
