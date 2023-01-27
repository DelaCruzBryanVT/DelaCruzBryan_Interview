package com.codeteam.CrudCode.Service;

import com.codeteam.CrudCode.Model.Employee;
import java.util.List;

public interface EmployeeService {

    List<Employee> list();

    Employee findById(Integer id);

    Employee save(Employee ent);

    void delete(Integer entId);
}
