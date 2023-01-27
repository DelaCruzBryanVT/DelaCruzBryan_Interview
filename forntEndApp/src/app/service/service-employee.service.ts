import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { DepartmentEmployee } from '../Models/DepartmentEmployee';
import { EmployeeClass } from '../Models/Employee';

@Injectable({
  providedIn: 'root'
})
export class ServiceEmployeeService {

  urlEmp = 'http://localhost:8080/api/employee'
  urlDepEmp = 'http://localhost:8080/api/departmentEmployee'

  constructor(private http: HttpClient) { }

  //#region Employee
  getEmployee(): Observable<any> {
    return this.http.get(this.urlEmp)
  }

  getEmployeeById(id: string): Observable<any> {
    return this.http.get(this.urlEmp + '/' + id)
  }

  save(ent: EmployeeClass): Observable<any> {
    return this.http.post(this.urlEmp, ent)
  }

  modify(id: string, ent: EmployeeClass): Observable<any> {
    return this.http.put(this.urlEmp + '/' + id, ent)
  }

  delete(id: string): Observable<any> {
    return this.http.delete(this.urlEmp + '/' + id)
  }

  //#endregion

   //#region DepartmentEmployee
   getDepartmentEmployee(): Observable<any> {
    return this.http.get(this.urlDepEmp)
  }

  getDepartmentEmployeeById(id: string): Observable<any> {
    return this.http.get(this.urlDepEmp + '/' + id)
  }

  saveDepartmentEmployee(ent: DepartmentEmployee): Observable<any> {
    return this.http.post(this.urlDepEmp, ent)
  }

  modifyDepartmentEmployee(id: string, ent: DepartmentEmployee): Observable<any> {
    return this.http.put(this.urlDepEmp + '/' + id, ent)
  }

  deleteDepartmentEmployee(id: string): Observable<any> {
    return this.http.delete(this.urlDepEmp + '/' + id)
  }

  //#endregion
}
