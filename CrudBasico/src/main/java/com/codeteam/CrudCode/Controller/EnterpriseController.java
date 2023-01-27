package com.codeteam.CrudCode.Controller;

import com.codeteam.CrudCode.Model.Enterprise;
import com.codeteam.CrudCode.Service.EnterpriseService;
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

public class EnterpriseController {

    @Autowired
    EnterpriseService entServ;

    @GetMapping("/enterprise")
    public List<Enterprise> list() {
        return entServ.list();
    }

    @PostMapping("/enterprise")
    public Enterprise save(@RequestBody Enterprise ent) {
        return entServ.save(ent);
    }

    @GetMapping("/enterprise/{id}")
    public Enterprise getEnterpise(@PathVariable Integer id) {
        return entServ.findById(id);
    }

    @PutMapping("/enterprise/{id}")
    public Enterprise modify(@RequestBody Enterprise ent, @PathVariable Integer id) {
        Enterprise entAct = entServ.findById(id);
        entAct.setEntCreatedBy(ent.getEntCreatedBy());
        entAct.setEntCreatedDate(ent.getEntCreatedDate());
        entAct.setEntModifiedBy(ent.getEntModifiedBy());
        entAct.setEntModifiedDate(ent.getEntModifiedDate());
        entAct.setEntStatus(ent.isEntStatus());
        entAct.setEntAddress(ent.getEntAddress());
        entAct.setEntName(ent.getEntName());
        entAct.setEntPhone(ent.getEntPhone());
        return entServ.save(entAct);
    }

    @DeleteMapping("/enterprise/{id}")
    public void delete(@PathVariable Integer id) {
        entServ.delete(id);
    }
}
