package com.codeteam.CrudCode.Controller;

import com.codeteam.CrudCode.Model.Employee;
import com.codeteam.CrudCode.Service.EmployeeService;
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

public class EmployeeController {

    @Autowired
    EmployeeService empServ;

    @GetMapping("/employee")
    public List<Employee> list() {
        return empServ.list();
    }

    @PostMapping("/employee")
    public Employee save(@RequestBody Employee ent) {
        return empServ.save(ent);
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable Integer id) {
        return empServ.findById(id);
    }

    @PutMapping("/employee/{id}")
    public Employee modify(@RequestBody Employee ent, @PathVariable Integer id) {
        Employee entAct = empServ.findById(id);
        entAct.setEmpCreatedBy(ent.getEmpCreatedBy());
        entAct.setEmpCreatedDate(ent.getEmpCreatedDate());
        entAct.setEmpModifiedBy(ent.getEmpModifiedBy());
        entAct.setEmpModifiedDate(ent.getEmpModifiedDate());
        entAct.setEmpStatus(ent.isEmpStatus());
        entAct.setEmpAge(ent.getEmpAge());
        entAct.setEmpEmail(ent.getEmpEmail());
        entAct.setEmpName(ent.getEmpName());
        entAct.setEmpPosition(ent.getEmpPosition());
        entAct.setEmpSurname(ent.getEmpSurname());
        return empServ.save(entAct);
    }

    @DeleteMapping("/employee/{id}")
    public void delete(@PathVariable Integer id) {
        empServ.delete(id);
    }
}
