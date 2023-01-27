package com.codeteam.CrudCode.Service;

import com.codeteam.CrudCode.Model.Department;
import java.util.List;

public interface DepartmentService {

    List<Department> list();

    Department findById(Integer id);

    Department save(Department ent);

    void delete(Integer entId);
}
