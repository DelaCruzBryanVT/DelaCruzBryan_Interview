package com.codeteam.CrudCode.Service;

import com.codeteam.CrudCode.Dao.DepartmentEmployeeDao;
import com.codeteam.CrudCode.Model.DepartmentEmployee;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DepartmentEmployeeServiceImplement implements DepartmentEmployeeService {

    @Autowired
    private DepartmentEmployeeDao depDao;

    @Override
    @Transactional(readOnly = true)
    public List<DepartmentEmployee> list() {
        return (List<DepartmentEmployee>) depDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public DepartmentEmployee findById(Integer id) {
        return depDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = false)
    public DepartmentEmployee save(DepartmentEmployee ent) {
        return depDao.save(ent);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Integer entId) {
        depDao.deleteById(entId);
    }
}
