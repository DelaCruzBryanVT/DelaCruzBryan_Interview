package com.codeteam.CrudCode.Dao;

import com.codeteam.CrudCode.Model.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentDao extends CrudRepository<Department, Integer> {

}
