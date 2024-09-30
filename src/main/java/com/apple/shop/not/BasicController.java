package com.apple.shop.not;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //@붙이면 자동으로 main 함수에서 실행됨
public class BasicController {
    
    @GetMapping("/") //http://localhost:8080/ 로 지정
    String hello(){
        return "index.html";
    }

    @GetMapping("/about")
    @ResponseBody //return 값에 있는문자 그대로를 보내주세요~
    String about(){
        return "나는 성윤";
    }

}
