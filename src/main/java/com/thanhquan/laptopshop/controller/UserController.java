package com.thanhquan.laptopshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.thanhquan.laptopshop.domain.User;
import com.thanhquan.laptopshop.service.UserService;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getHomePage(Model model) {
        model.addAttribute("data", "test");
        return "home.jsp";
    }

    // List User
    @GetMapping("/admin/user")
    public String getUserPage() {
        return "admin/user";
    }

    //detail User 
    @GetMapping("/admin/user/{id}")
    public String getDetailUser(@PathVariable Long id) {
        System.out.println("id" + id);
        return "home";
    }

    //update user
    public String getUpdateUser(Model model, @PathVariable Long id) {
        var currentUser = this.userService.findUserById(id);
        model.addAttribute("updatedUser", currentUser);
        System.out.println(id);
        return "admin/user/update";
    }

    // Create User
    @GetMapping("/admin/user/create")
    public String getCreateUserPage(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }

    @PostMapping("/admin/user/create")
    public String createUser(Model model, @ModelAttribute User newUser) {
        this.userService.handleSaveUser(newUser);
        return "redirect:/admin/user";
    }

    //delete user

}
