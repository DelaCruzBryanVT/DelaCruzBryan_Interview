import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Enterprise } from '../Models/Enterprise';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ServiceEnterpriseService {

  url = 'http://localhost:8080/api/enterprise'

  constructor(private http: HttpClient) { }

  getEnterprise(): Observable<any> {
    return this.http.get(this.url)
  }

  getEnterpriseById(id: string): Observable<any> {
    return this.http.get(this.url + '/' + id)
  }

  save(ent: Enterprise): Observable<any> {
    return this.http.post(this.url, ent)
  }

  modify(id: string, ent: Enterprise): Observable<any> {
    return this.http.put(this.url + '/' + id, ent)
  }

  delete(id: string): Observable<any> {
    return this.http.delete(this.url + '/' + id)
  }
}
