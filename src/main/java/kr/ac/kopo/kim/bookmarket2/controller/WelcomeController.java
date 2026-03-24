package kr.ac.kopo.kim.bookmarket2.controller;

import org.springframework.stereotype.Controller; // 추가됨
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    @GetMapping("/home")
    public String welcomeMethod(){

        return "welcome";
    }
}