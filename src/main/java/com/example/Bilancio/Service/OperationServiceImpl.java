package com.example.Bilancio.Service;

import com.example.Bilancio.DAO.OperationDAO;
import com.example.Bilancio.Model.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OperationServiceImpl implements OperationService{
    @Autowired
    private OperationDAO operationDAO;
    @Override
    public void createOperation(Operation operation) {
        operationDAO.save(operation);
    }

    @Override
    public List<Operation> getOperations() {
        List<Operation> operations = (List<Operation>) operationDAO.findAll();
        Comparator<Operation> byDate = Comparator.comparing(Operation::getDate).reversed();
        operations = operations
                .stream()
                .sorted(byDate)
                .collect(Collectors.toList());
        return operations;
    }

    @Override
    public Operation getOperationById(int id) {
        return operationDAO.findById(id).get();
    }

    @Override
    public void deleteOperation(Operation operation) {
        operationDAO.delete(operation);
    }

    @Override
    public double getBalance(List<Operation> operations) {
        return operations
                .stream()
                .mapToDouble(Operation::getAmount)
                .reduce(0.0, Double::sum);
    }
}
