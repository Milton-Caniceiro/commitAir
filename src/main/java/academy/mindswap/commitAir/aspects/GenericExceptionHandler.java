package academy.mindswap.commitAir.aspects;

import academy.mindswap.commitAir.exception.*;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component
@ControllerAdvice
public class GenericExceptionHandler {

    Logger logger = LoggerFactory.getLogger(GenericExceptionHandler.class);

    @ExceptionHandler({PasswordNotMatch.class})
    public ResponseEntity<String> handleNotFoundException(Exception ex) {
        logger.error("Resource not found: " + ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Password doesn't match");
    }


    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<String> handleNotFoundException(EntityNotFoundException ex) {
        logger.error("Resource not found: " + ex);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entity not found");
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<String> handleGenericException(Exception ex) {
        logger.error("Unknown Exception: " + ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred.");
    }

    @ExceptionHandler({UserDoesntExists.class})
    public ResponseEntity<String> handleUserDoesntExists(Exception ex) {
        logger.error("Resource not found: " + ex);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Doesn't exists");
    }

    @ExceptionHandler({PassengerDoesntExists.class})
    public ResponseEntity<String> handlePassengerDoesntExists(Exception ex) {
        logger.error("Resource not found: " + ex);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Passenger Doesn't exists");
    }

    @ExceptionHandler({FlightDoesntExists.class})
    public ResponseEntity<String> handleFlightDoesntExists(Exception ex) {
        logger.error("Resource not found: " + ex);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Flight Doesn't exists");
    }

    @ExceptionHandler({InsufficientSeats.class})
    public ResponseEntity<String> handleinsufficientSeats(Exception ex) {
        logger.error("Resource not found: " + ex);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Insufficient Seats Available");
    }

    @ExceptionHandler({BookingNotExists.class})
    public ResponseEntity<String> handleBookingNotExists(Exception ex) {
        logger.error("Resource not found: " + ex);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bookind Doesn't Exists");
    }

    @ExceptionHandler({UserNotMatch.class})
    public ResponseEntity<String> handleUserNotMatch(Exception ex) {
        logger.error("Resource not found: " + ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Don't have permissions to access here");
    }


}