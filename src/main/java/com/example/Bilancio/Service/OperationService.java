package com.example.Bilancio.Service;

import com.example.Bilancio.Model.Operation;

import java.util.List;

public interface OperationService {
    void createOperation(Operation operation);
    List<Operation> getOperations();
    Operation getOperationById(int id);
    void deleteOperation(Operation operation);
    double getBalance(List<Operation> operations);
}
