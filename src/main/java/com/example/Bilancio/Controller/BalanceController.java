package com.example.Bilancio.Controller;

import com.example.Bilancio.Model.Operation;
import com.example.Bilancio.Service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/")
public class BalanceController {
    @Autowired
    private OperationService operationService;
    @GetMapping
    public String getPage(Model model){
        List<Operation> operations = operationService.getOperations();
        model.addAttribute("operations", operations);
        model.addAttribute("balance", operationService.getBalance(operations));
        return "balance";
    }
    @GetMapping("/delete")
    public String deleteOperation(@RequestParam("id") int id){
        operationService.deleteOperation(operationService.getOperationById(id));
        return "redirect:/";
    }
}
