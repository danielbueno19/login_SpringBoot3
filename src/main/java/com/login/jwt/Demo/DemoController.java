package com.login.jwt.Demo;

import org.springframework.web.bind.annotation.PostMapping;

public class DemoController {
    
    @PostMapping("demo")
    public String welcome(){
        return "welcome form secury endpoint";
    }
}
