package org.emel.CurrencyConversionService.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.time.LocalDateTime;
import javax.servlet.http.HttpServletRequest;

/**
 * Глобальный класс для обработки всех исключений в REST контролерах
 */
@RestControllerAdvice
public class GlobalControllerExceptionHandler {

    /**
     * Обработчик исключений со статусом 400
     *
     * @param request информация о запросе
     * @param e       выброшенное исключение
     * @return json с информацией об ошибке
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({CurrencyRateIsNotSupported.class})
    private ResponseEntity<ErrorResponse> handleBadRequestException(HttpServletRequest request, Exception e) {
        ErrorResponse response = new ErrorResponse(
                LocalDateTime.now(),
                400,
                "Bad Request",
                request.getRequestURL().toString(),
                e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST); // Статус - 400
    }

    /**
     * Обработчик исключений со статусом 500
     *
     * @param request информация о запросе
     * @param e       выброшенное исключение
     * @return json с информацией об ошибке
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({ExchangeRateRestApiException.class})
    private ResponseEntity<ErrorResponse> handleInternalServerException(HttpServletRequest request, Exception e) {
        ErrorResponse response = new ErrorResponse(
                LocalDateTime.now(),
                500,
                "Internal Server Error",
                request.getRequestURL().toString(),
                e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR); // Статус - 500
    }
}

