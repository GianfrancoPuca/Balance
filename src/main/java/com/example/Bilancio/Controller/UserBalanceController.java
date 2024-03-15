package com.example.Bilancio.Controller;

import com.example.Bilancio.Model.Operation;
import com.example.Bilancio.Service.OperationService;
import com.example.Bilancio.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/userbalance")
public class UserBalanceController {
    @Autowired
    private UserService userService;
    @Autowired
    private OperationService operationService;
    @GetMapping
    public String getPage(Integer id, Model model){
        List<Operation> operations = userService.getOperationsForUser(id);
        model.addAttribute("operations", operations);
        model.addAttribute("balance", operationService.getBalance(operations));
        return "userbalance";
    }
    @GetMapping("/delete")
    public String deleteOperation(@RequestParam(value = "id") int id){
        operationService.deleteOperation(operationService.getOperationById(id));
        return "redirect:/";
    }
}
