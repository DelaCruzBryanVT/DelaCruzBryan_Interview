package com.codeteam.CrudCode.Controller;

import com.codeteam.CrudCode.Model.Department;
import com.codeteam.CrudCode.Service.DepartmentService;
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

public class DepartmentController {

    @Autowired
    DepartmentService depServ;

    @GetMapping("/department")
    public List<Department> list() {
        return depServ.list();
    }

    @PostMapping("/department")
    public Department save(@RequestBody Department ent) {
        return depServ.save(ent);
    }

    @GetMapping("/department/{id}")
    public Department getDepartment(@PathVariable Integer id) {
        return depServ.findById(id);
    }

    @PutMapping("/department/{id}")
    public Department modify(@RequestBody Department ent, @PathVariable Integer id) {
        Department entAct = depServ.findById(id);
        entAct.setEntId(ent.getEntId());
        entAct.setDepCreatedBy(ent.getDepCreatedBy());
        entAct.setDepCreatedDate(ent.getDepCreatedDate());
        entAct.setDepModifiedBy(ent.getDepModifiedBy());
        entAct.setDepModifiedDate(ent.getDepModifiedDate());
        entAct.setDepStatus(ent.isDepStatus());
        entAct.setDepDescription(ent.getDepDescription());
        entAct.setDepName(ent.getDepName());
        entAct.setDepPhone(ent.getDepPhone());
        return depServ.save(entAct);
    }

    @DeleteMapping("/department/{id}")
    public void delete(@PathVariable Integer id) {
        depServ.delete(id);
    }
}
