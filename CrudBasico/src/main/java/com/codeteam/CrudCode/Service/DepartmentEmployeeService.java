package com.codeteam.CrudCode.Service;

import com.codeteam.CrudCode.Model.DepartmentEmployee;
import java.util.List;

public interface DepartmentEmployeeService {

    List<DepartmentEmployee> list();

    DepartmentEmployee findById(Integer id);

    DepartmentEmployee save(DepartmentEmployee ent);

    void delete(Integer entId);
}
