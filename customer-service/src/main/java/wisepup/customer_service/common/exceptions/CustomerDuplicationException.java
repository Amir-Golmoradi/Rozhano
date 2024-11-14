package wisepup.customer_service.common.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class CustomerDuplicationException extends RuntimeException {
    public CustomerDuplicationException(String message) {
        super(message);
    }
}
