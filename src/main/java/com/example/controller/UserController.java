package com.example.controller;

import com.example.model.User;
import com.example.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.getAll());
        return "all-users";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("user", new User());
        return "user-form";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute User user) {
        if (user.getId() != null && user.getId() != 0) {
            userService.update(user);
        } else {
            userService.create(user);
        }
        return "redirect:/";
    }

    @GetMapping("/update")
    public String showUpdateForm(@RequestParam("id") Long id, Model model) {
        User user = userService.getById(id);
        if (user != null) {
            model.addAttribute("user", user);
            return "user-form";
        }
        return "redirect:/";
    }

    @DeleteMapping("/delete")
    public String deleteUser(@RequestParam("id") Long id, HttpServletRequest request) {
        System.out.println("=== DELETE MAPPING CALLED ===");
        System.out.println("Request Method: " + request.getMethod());
        System.out.println("Parameter _method: " + request.getParameter("_method"));
        System.out.println("User ID: " + id);

        userService.delete(id);
        return "redirect:/";
    }
}