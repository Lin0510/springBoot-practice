package com.example.demo1.web.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLException;

@ControllerAdvice
public class ExceptionController {

    // RuntimeException 異常頁面控制
    @ExceptionHandler(RuntimeException.class)
    public Object runtimeExceptionHandler(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.OK).body(e.getMessage());
    }

    // SQLException 異常頁面控制
    @ExceptionHandler(SQLException.class)
    public Object sqlExceptionHandler() {
        String msg = "資料庫錯誤";
        return ResponseEntity.status(HttpStatus.OK).body(msg);
    }

}
