package com.codeteam.CrudCode.Controller;

import com.codeteam.CrudCode.Model.DepartmentEmployee;
import com.codeteam.CrudCode.Service.DepartmentEmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping({"/api"})

public class DepartmentEmployeeController {

    @Autowired
    DepartmentEmployeeService depServ;

    @GetMapping("/departmentEmployee")
    public List<DepartmentEmployee> list() {
        return depServ.list();
    }

    @PostMapping("/departmentEmployee")
    public DepartmentEmployee save(@RequestBody DepartmentEmployee ent) {
        return depServ.save(ent);
    }

    @GetMapping("/departmentEmployee/{id}")
    public DepartmentEmployee getDepartmentEmployee(@PathVariable Integer id) {
        return depServ.findById(id);
    }

    @PutMapping("/departmentEmployee/{id}")
    public DepartmentEmployee modify(@RequestBody DepartmentEmployee ent, @PathVariable Integer id) {
        DepartmentEmployee entAct = depServ.findById(id);
        entAct.setDepId(ent.getDepId());
        entAct.setEmpId(ent.getEmpId());
        entAct.setDepEmpCreatedBy(ent.getDepEmpCreatedBy());
        entAct.setDepEmpCreatedDate(ent.getDepEmpCreatedDate());
        entAct.setDepEmpModifiedBy(ent.getDepEmpModifiedBy());
        entAct.setDepEmpModifiedDate(ent.getDepEmpModifiedDate());
        entAct.setDepEmpStatus(ent.isDepEmpStatus());
        return depServ.save(entAct);
    }

    @DeleteMapping("/departmentEmployee/{id}")
    public void delete(@PathVariable Integer id) {
        depServ.delete(id);
    }
}
