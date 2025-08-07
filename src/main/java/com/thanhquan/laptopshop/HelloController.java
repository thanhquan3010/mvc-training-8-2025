package com.thanhquan.laptopshop;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/")
    public String helloWorld() {
        return "trang chủ";
    }

    @GetMapping("/user")
    public String User() {
        return "user page";
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "admin page";
    }
}
