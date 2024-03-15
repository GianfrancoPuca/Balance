package com.example.Bilancio.Service;

import com.example.Bilancio.DAO.OperationDAO;
import com.example.Bilancio.DAO.UserDAO;
import com.example.Bilancio.Model.Operation;
import com.example.Bilancio.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private OperationDAO operationDAO;
    @Override
    public List<Operation> getOperationsForUser(int id) {
        List<Operation> operations = (List<Operation>) operationDAO.findAll();
        List<Operation> operationsUser = new ArrayList<>();
        for (Operation o : operations){
           if (o.getUser().getId() == id) {
               operationsUser.add(o);
           }
        }
        return operationsUser;
    }

    @Override
    public void createUser(User user) {
        userDAO.save(user);
    }

    @Override
    public List<User> getUsers() {
        return (List<User>) userDAO.findAll();
    }


}
