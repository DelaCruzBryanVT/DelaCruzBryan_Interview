import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Department } from '../Models/Department';
import { Enterprise } from '../Models/Enterprise';
import { ServiceDepartmentService } from '../service/service-department.service';
import { ServiceEnterpriseService } from '../service/service-enterprise.service';

@Component({
  selector: 'app-department',
  templateUrl: './department.component.html',
  styleUrls: ['./department.component.css']
})
export class DepartmentComponent implements OnInit {

  ent: Department = new Department;
  entAct: Department = new Department;
  flagForm: boolean = false;
  enterpriseList: Enterprise[] = [];
  departmentList: Department[] = [];


  constructor(
    private serviceEnt: ServiceEnterpriseService,
    private serviceDep: ServiceDepartmentService,
    private router: Router) {
  }

  ngOnInit(): void {
    setTimeout(() => {
      this.listDepartment()
    }, 500);
  }

  listDepartment() {
    this.serviceEnt.getEnterprise()
      .subscribe(data => {
        this.enterpriseList = data;
      })

    this.serviceDep.getDepartment()
      .subscribe(data => {
        this.departmentList = data;
      })
  }

  mainMenu() {
    this.router.navigate(["main-menu"], { queryParams: { role: 'admin' } })
  }

  save() {
    this.ent.depCreatedBy = 'admin'
    let date: Date = new Date();
    this.ent.depCreatedDate = date
    this.serviceDep.save(this.ent).subscribe(
      res => {
        this.router.navigate(['/department'])
        this.listDepartment()
        this.ent.depName = ''
        this.ent.depDescription = ''
        this.ent.depPhone = ''
        this.ent.depId = 0
        this.ent.depStatus = false
        this.flagForm = false
      }
    )
  }

  delete(id: number) {
    this.serviceDep.delete(id + "").subscribe(res => {
      alert('Elemento eliminado!')
      this.listDepartment()
      this.router.navigate(['/department'])
      this.listDepartment()
      this.ent.depName = ''
      this.ent.depDescription = ''
      this.ent.depPhone = ''
      this.ent.depStatus = false
      this.flagForm = false
    })
  }

  modify(id: number) {
    this.flagForm = true
    this.serviceDep.getDepartmentById(id + "")
      .subscribe(res => {
        this.entAct = res
      })
  }

  saveModify() {
    this.entAct.depModifiedBy = 'admin'
    let dateModify: Date = new Date();
    this.entAct.depModifiedDate = dateModify
    this.serviceDep.save(this.entAct).subscribe(
      res => {
        this.router.navigate(['/department'])
        this.listDepartment()
        this.entAct.depName = ''
        this.entAct.depDescription = ''
        this.entAct.depPhone = ''
        this.entAct.depStatus = false
        this.flagForm = false
      }
    )
  }

  onlyNumbers(event: any): boolean {
    const charCode = (event.which) ? event.which : event.keyCode;

    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
      return false
    }
    return true
  }
}
