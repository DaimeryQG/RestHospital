package com.imss.qro.Exeptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ValidationExceptionHandler {

    // Crear el logger
    private static final Logger LOGGER = LoggerFactory.getLogger(ValidationExceptionHandler.class);

    // Manejo de excepciones de validación
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errores = new HashMap<>();

        // Log de inicio del proceso de validación fallida
        LOGGER.error("Error de validación recibido. Número de errores: {}", ex.getBindingResult().getErrorCount());

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String campo = ((FieldError) error).getField();
            String mensaje = error.getDefaultMessage();
            errores.put(campo, mensaje);
            
            // Log de cada error de validación encontrado
            LOGGER.error("Error en campo '{}': {}", campo, mensaje);
        });

        // Log de finalización del manejo de errores
        LOGGER.error("Validación fallida, retornando respuesta con errores.");

        return new ResponseEntity<>(errores, HttpStatus.BAD_REQUEST);
    }
}
