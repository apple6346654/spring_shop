package com.apple.shop;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice //모든컨트롤러에서 파일의 에러를 캐치한다.
public class MyExcptionHandler {
    @ExceptionHandler(Exception.class) //현재 클레스에서 Exception(에러)가 발생하면  handler()안에 있는 코드 실행
    public ResponseEntity<String> handler(){
        return ResponseEntity.status(400).body("에러남");


    }

}
