package com.example.Bilancio.Controller;

import com.example.Bilancio.Model.User;
import com.example.Bilancio.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/newuser")
public class NewUserController {
    @Autowired
    private UserService userService;
    @GetMapping
    public String getPage(Model model){
        model.addAttribute("user", new User());
        return "newuser";
    }
    @PostMapping
    public String formManager(@Valid @ModelAttribute("user") User user,
                              BindingResult result,
                              Model model){
        if(result.hasErrors()) {
            return "newuser";
        }
        userService.createUser(user);
        return "redirect:/operation";
    }
}



