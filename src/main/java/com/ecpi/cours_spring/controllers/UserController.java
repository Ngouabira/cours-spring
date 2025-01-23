package com.ecpi.cours_spring.controllers;

import com.ecpi.cours_spring.model.User;
import com.ecpi.cours_spring.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/create")
    public String create(Model model){
        var user = new User();
        model.addAttribute("user", user);
        return  "creatUser";
    }

    @PostMapping
    public String store(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()) {
            return  "creatUser";
        }

        userService.create(user);
        redirectAttributes.addFlashAttribute("message", "L'utilisateur a été crée!");
        return "redirect:/users";
    }

    @GetMapping
    public String read(Model model){
        var users =  userService.read();
        model.addAttribute("users", users);
        return  "user";
    }

    @GetMapping(value = "/edit/{id}")
    public String edit(Model model, @PathVariable("id") int id){
        var user = userService.find(id);
        model.addAttribute("user", user);
        return  "EditPatient";
    }


    @PostMapping(value = "/update")
    public String update(@ModelAttribute("user") User user, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()) {
            return  "EditPatient";
        }
        userService.update(user);
        redirectAttributes.addFlashAttribute("message", "L'utlisateur a été modifié!");
        return "redirect:/users";
    }



    @GetMapping("/{id}")
    public String delete(@PathVariable("id") int id, RedirectAttributes redirectAttributes){
          userService.delete(id);
        redirectAttributes.addFlashAttribute("message", "L'utilisateur a été supprimé!");
        return "redirect:/patients";
    }
}
