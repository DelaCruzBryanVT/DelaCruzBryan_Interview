package com.codeteam.CrudCode.Dao;

import com.codeteam.CrudCode.Model.DepartmentEmployee;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentEmployeeDao extends CrudRepository<DepartmentEmployee, Integer> {

}
