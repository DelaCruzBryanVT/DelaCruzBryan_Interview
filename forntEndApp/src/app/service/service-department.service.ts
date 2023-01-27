import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Department } from '../Models/Department';

@Injectable({
  providedIn: 'root'
})
export class ServiceDepartmentService {

  url = 'http://localhost:8080/api/department'

  constructor(private http: HttpClient) { }

  getDepartment(): Observable<any> {
    return this.http.get(this.url)
  }

  getDepartmentById(id: string): Observable<any> {
    return this.http.get(this.url + '/' + id)
  }

  save(ent: Department): Observable<any> {
    return this.http.post(this.url, ent)
  }

  modify(id: string, ent: Department): Observable<any> {
    return this.http.put(this.url + '/' + id, ent)
  }

  delete(id: string): Observable<any> {
    return this.http.delete(this.url + '/' + id)
  }
}
