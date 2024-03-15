package com.example.Bilancio.DAO;

import com.example.Bilancio.Model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserDAO extends CrudRepository<User, Integer> {
    //List<User> getAllUsers();
}
