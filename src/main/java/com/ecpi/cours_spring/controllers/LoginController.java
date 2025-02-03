package com.ecpi.cours_spring.controllers;

import com.ecpi.cours_spring.model.User;
import com.ecpi.cours_spring.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final UserService userService;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping(value = "/register")
    public String registerForm(Model model){
        var user = new User();
        model.addAttribute("user", user);
        return  "register";
    }

    @PostMapping(value = "/register")
    public String register(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()) {
            return  "register";
        }

        userService.create(user);
        redirectAttributes.addFlashAttribute("message", "Votre compte a bien été crée!");
        return "redirect:/login";
    }
}
