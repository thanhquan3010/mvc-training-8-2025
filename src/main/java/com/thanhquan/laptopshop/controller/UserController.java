package com.thanhquan.laptopshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.thanhquan.laptopshop.domain.User;

@Controller
public class UserController {
    @GetMapping("/")
    public String getHomePage() {
        return "home.jsp";
    }

    @GetMapping("/admin/user")
    public String getUserPage() {
        return "admin/user";
    }

    @GetMapping("/admin/user/create")
    public String getCreateUserPage(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }
}
