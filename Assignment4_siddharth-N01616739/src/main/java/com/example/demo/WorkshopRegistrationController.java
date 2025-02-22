package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class WorkshopRegistrationController {

    @Autowired
    private WorkshopRegistrationRepository repository;

    @GetMapping("/register")
    public String showForm(Model model) {
        model.addAttribute("registration", new WorkshopRegistration());
        return "register";  
    }

    @PostMapping("/register")
    public String submitForm(@Valid @ModelAttribute("registration") WorkshopRegistration registration, 
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "register";
        }
        repository.save(registration);
        model.addAttribute("successMessage", "Registration successful!");
        return "register";
    }
}
