package com.example.Bilancio.DAO;

import com.example.Bilancio.Model.Operation;
import org.springframework.data.repository.CrudRepository;

public interface OperationDAO extends CrudRepository<Operation, Integer> {
}
