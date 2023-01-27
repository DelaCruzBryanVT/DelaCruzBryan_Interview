import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Department } from '../Models/Department';
import { DepartmentEmployee } from '../Models/DepartmentEmployee';
import { EmployeeClass } from '../Models/Employee';
import { Enterprise } from '../Models/Enterprise';
import { ServiceDepartmentService } from '../service/service-department.service';
import { ServiceEmployeeService } from '../service/service-employee.service';
import { ServiceEnterpriseService } from '../service/service-enterprise.service';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})

export class EmployeeComponent implements OnInit {

  ent: EmployeeClass = new EmployeeClass;
  entAct: EmployeeClass = new EmployeeClass;
  depEmp: DepartmentEmployee = new DepartmentEmployee;
  idEmployee: number = 0;
  idDepartmentEmployee: number = 0;
  flagForm: boolean = false;
  employeeList: EmployeeClass[] = [];
  departmentList: Department[] = [];


  constructor(
    private serviceDep: ServiceDepartmentService,
    private serviceEmp: ServiceEmployeeService,
    private router: Router) {
  }

  ngOnInit(): void {
    setTimeout(() => {
      this.listEmployee()
    }, 500);
  }

  listEmployee() {
    this.serviceDep.getDepartment()
      .subscribe(data => {
        this.departmentList = data;
      })
    this.serviceEmp.getEmployee()
      .subscribe(data => {
        this.employeeList = data;
      })
  }

  mainMenu() {
    this.router.navigate(["main-menu"], { queryParams: { role: 'admin' } })
  }

  save() {
    this.ent.empCreatedBy = 'admin'
    let date: Date = new Date();
    this.ent.empCreatedDate = date
    this.serviceEmp.save(this.ent).subscribe(
      res => {
        this.depEmp.depId = this.depEmp.depEmpId
        this.depEmp.empId = Number.parseInt(res.empId)
        this.depEmp.depEmpCreatedBy = 'admin'
        let dateDepEmp: Date = new Date();
        this.depEmp.depEmpCreatedDate = dateDepEmp
        this.depEmp.depEmpStatus = this.ent.empStatus
        this.serviceEmp.saveDepartmentEmployee(this.depEmp).subscribe(
          resDepEmp => { }
        )
        this.router.navigate(['/employee'])
        this.listEmployee()
        this.ent.empName = ''
        this.ent.empSurname = ''
        this.ent.empAge = 0
        this.ent.empEmail = ''
        this.flagForm = false
        this.ent.empPosition = ''
        this.depEmp.depId = 0
        this.depEmp.depEmpId = 0
      }
    )
  }

  modify(id: number) {
    this.flagForm = true
    this.serviceEmp.getEmployeeById(id + "")
      .subscribe(res => {
        this.entAct = res
      })

  }

  saveModify() {
    this.entAct.empModifiedBy = 'admin'
    let dateModify: Date = new Date();
    this.entAct.empModifiedDate = dateModify
    this.serviceEmp.save(this.entAct).subscribe(
      res => {
        this.depEmp.depId = this.depEmp.depEmpId
        this.depEmp.empId = Number.parseInt(res.empId)
        this.depEmp.depEmpModifiedBy = 'admin'
        let dateDepEmp: Date = new Date();
        this.depEmp.depEmpModifiedDate = dateDepEmp
        this.depEmp.depEmpStatus = this.ent.empStatus
        this.serviceEmp.saveDepartmentEmployee(this.depEmp).subscribe(
          res => { }
        )
        this.router.navigate(['/employee'])
        this.listEmployee()
        this.entAct.empName = ''
        this.entAct.empSurname = ''
        this.entAct.empAge = 0
        this.entAct.empEmail = ''
        this.flagForm = false
        this.entAct.empPosition = ''
        this.depEmp.depId = 0
        this.depEmp.depEmpId = 0
      }
    )
  }

  delete(id: number) {
    this.serviceEmp.delete(id + "").subscribe(res => {
      alert('Elemento eliminado!')
      this.listEmployee()
      this.router.navigate(['/employee'])
      this.entAct.empName = ''
      this.entAct.empSurname = ''
      this.entAct.empAge = 0
      this.entAct.empEmail = ''
      this.flagForm = false
      this.entAct.empPosition = ''
      this.depEmp.depId = 0
      this.depEmp.depEmpId = 0
    })
  }

}
