package com.example.Bilancio.Service;

import com.example.Bilancio.Model.Operation;
import com.example.Bilancio.Model.User;

import java.util.List;

public interface UserService {
    List<Operation> getOperationsForUser (int id);
    void createUser(User user);
    List<User> getUsers();
}
