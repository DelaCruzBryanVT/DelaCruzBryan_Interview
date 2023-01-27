package com.codeteam.CrudCode.Service;

import com.codeteam.CrudCode.Service.EnterpriseService;
import com.codeteam.CrudCode.Model.Enterprise;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.codeteam.CrudCode.Dao.EnterpriseDao;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EnterpriseServiceImplement implements EnterpriseService {

    @Autowired
    private EnterpriseDao entDao;

    @Override
    @Transactional(readOnly = true)
    public List<Enterprise> list() {
        return (List<Enterprise>) entDao.findAll();
    }

    @Override
    @Transactional(readOnly = false)
    public Enterprise save(Enterprise ent) {
        return entDao.save(ent);
    }
    
    @Override
    @Transactional(readOnly = false)
    public void delete(Integer entId) {
        entDao.deleteById(entId);
    }

    @Override
    @Transactional(readOnly = true)
    public Enterprise findById(Integer id) {
        return entDao.findById(id).orElse(null);
    }
}
