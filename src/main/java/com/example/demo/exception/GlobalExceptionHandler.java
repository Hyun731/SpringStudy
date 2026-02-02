package com.example.demo.exception;

import com.example.demo.DTO.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice //@RestController에서 발생하는 모든 예외를 관리하고 가로채는 역할
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFound.class) //ResourceNotFound 예외가 실행되었을 이 메서드가 실행되도록 연결해줌
    public ResponseEntity<ErrorResponse> handleResourceNotFound(ResourceNotFound e) { //HTTP 상태 코드 Body 정보를 세밀하게 조절하 응답하기 위한 스프링 객체
        ErrorResponse error = new ErrorResponse(e.getMessage(), "NotFound404");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
    @ExceptionHandler(AlreadyExist.class)
    public ResponseEntity<ErrorResponse> handleAlreadyExist(AlreadyExist e) {
        ErrorResponse error = new ErrorResponse(e.getMessage(), "400");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
