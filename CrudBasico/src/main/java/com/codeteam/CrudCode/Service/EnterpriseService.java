package com.codeteam.CrudCode.Service;

import com.codeteam.CrudCode.Model.Enterprise;
import java.util.List;

public interface EnterpriseService {

    List<Enterprise> list();

    Enterprise findById(Integer id);

    Enterprise save(Enterprise ent);
    
    void delete(Integer entId);

}
