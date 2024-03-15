package com.example.Bilancio.Controller;

import com.example.Bilancio.Model.Operation;
import com.example.Bilancio.Model.User;
import com.example.Bilancio.Service.OperationService;
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

import java.util.List;

@Controller
@RequestMapping("operation")
public class OperationController {
    @Autowired
    private OperationService operationService;
    @Autowired
    private UserService userService;
    @GetMapping
    public String getPage(Model model){
        List<Operation> operations = operationService.getOperations();
        List<User> users = userService.getUsers();
        model.addAttribute("operations", operations);
        model.addAttribute("users", users);
        model.addAttribute("operation", new Operation());

        return "operation";
    }
    @PostMapping
    public String registerOperation(@Valid @ModelAttribute("operation") Operation operation, BindingResult result){
        if (result.hasErrors()){
            return "operation";
        }
        operationService.createOperation(operation);
        return "redirect:/";
    }
}
