package advice;

import exception.BusinessPortalException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppControllerAdvice {

    @ExceptionHandler(value = BusinessPortalException.class)
    public ResponseEntity adviceOnBusinessPortalException(BusinessPortalException ex) {
        System.out.println("Portal has thrown a business exception with message: "
                + ex.getMessage() + " and exception: " +ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex);
    }
}
