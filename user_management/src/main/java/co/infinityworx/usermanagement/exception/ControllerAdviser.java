package co.infinityworx.usermanagement.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class ControllerAdviser extends ResponseEntityExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> handleNotFoundException(NotFoundException exception, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        Map<String, Object> error = new LinkedHashMap<>();

        error.put("message", exception.getMessage());
        error.put("path", ((ServletWebRequest)request).getRequest().getRequestURI().toString());

        body.put("timestamp", LocalDateTime.now().format(DateTimeFormatter.ofPattern("EE, dd, MMM YYYY H:mm:ss a")));
        body.put("error", error);
        body.put("statuscode", HttpStatus.NOT_FOUND.value());

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", status.value());


        List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(x->x.getDefaultMessage()).collect(Collectors.toList());
        body.put("error", errors);
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
}
