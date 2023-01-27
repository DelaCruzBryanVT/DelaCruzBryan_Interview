package com.codeteam.CrudCode.Service;

import com.codeteam.CrudCode.Dao.DepartmentDao;
import com.codeteam.CrudCode.Model.Department;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DepartmentServiceImplement implements DepartmentService {

    @Autowired
    private DepartmentDao depDao;

    @Override
    @Transactional(readOnly = true)
    public List<Department> list() {
        return (List<Department>) depDao.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public Department findById(Integer id) {
        return depDao.findById(id).orElse(null);
    }
    
    @Override
    @Transactional(readOnly = false)
    public Department save(Department ent) {
        return depDao.save(ent);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Integer entId) {
        depDao.deleteById(entId);
    }
}
