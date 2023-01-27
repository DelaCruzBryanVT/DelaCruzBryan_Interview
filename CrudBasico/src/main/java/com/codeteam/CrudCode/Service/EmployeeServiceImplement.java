package com.codeteam.CrudCode.Service;

import com.codeteam.CrudCode.Dao.EmployeeDao;
import com.codeteam.CrudCode.Model.Employee;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeServiceImplement implements EmployeeService {

    @Autowired
    private EmployeeDao empDao;

    @Override
    @Transactional(readOnly = true)
    public List<Employee> list() {
        return (List<Employee>) empDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Employee findById(Integer id) {
        return empDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = false)
    public Employee save(Employee ent) {
        return empDao.save(ent);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Integer entId) {
        empDao.deleteById(entId);
    }

}
