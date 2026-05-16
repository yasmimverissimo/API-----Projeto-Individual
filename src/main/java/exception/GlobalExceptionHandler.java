package Atividade.ProjetoIndividual.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.logging.LogRecord;

@ControllerAdvice
public class GlobalExceptionHandler {

    //Estrutura usada para tratamento de ErroResponse inesperados
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErroResponse>handleGenericException(Exception e){
        ErroResponse erroResponse = new ErroResponse("Ocorreu um erro inesperado:" + e.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                LocalDateTime.now());
        return new ResponseEntity<>(erroResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //Tratamento para algo que não é encontrado
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErroResponse>handleBadRequest(RuntimeException e){
        ErroResponse erroResponse = new ErroResponse(e.getMessage(),
                HttpStatus.BAD_REQUEST.value(), LocalDateTime.now());
        return new ResponseEntity<>(erroResponse,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErroResponse>handleNotFound(ResourceNotFoundException e){
        ErroResponse erroResponse = new ErroResponse(e.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                LocalDateTime.now());
        return new ResponseEntity<>(erroResponse,HttpStatus.NOT_FOUND);
    }
}
