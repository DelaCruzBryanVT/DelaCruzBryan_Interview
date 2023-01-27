package com.codeteam.CrudCode.Dao;

import com.codeteam.CrudCode.Model.Employee;
import org.springframework.data.repository.CrudRepository;


public interface EmployeeDao extends CrudRepository<Employee, Integer> {
    
}
