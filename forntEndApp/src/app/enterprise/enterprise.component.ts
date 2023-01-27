import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Enterprise } from '../Models/Enterprise';
import { ServiceEnterpriseService } from '../service/service-enterprise.service'

@Component({
  selector: 'app-enterprise',
  templateUrl: './enterprise.component.html',
  styleUrls: ['./enterprise.component.css']
})
export class EnterpriseComponent implements OnInit {

  ent: Enterprise = new Enterprise;
  entAct: Enterprise = new Enterprise;
  flagForm: boolean = false;
  enterpriseList: Enterprise[] = [];

  constructor(private service: ServiceEnterpriseService, private router: Router) {

  }
  ngOnInit(): void {
    setTimeout(() => {
      this.listEnterpise()
    }, 500);

  }

  listEnterpise() {
    this.service.getEnterprise()
      .subscribe(data => {
        this.enterpriseList = data;
      })
  }

  save() {
    this.ent.entCreatedBy = 'admin'
    let date: Date = new Date();
    this.ent.entCreatedDate = date
    this.service.save(this.ent).subscribe(
      res => {
        this.router.navigate(['/enterprise'])
        this.listEnterpise()
        this.ent.entName = ''
        this.ent.entAddress = ''
        this.ent.entPhone = ''
        this.ent.entStatus = false
        this.flagForm = false
      }
    )
  }

  delete(id: number) {
    this.service.delete(id + "").subscribe(res => {
      alert('Elemento eliminado!')
      this.listEnterpise()
    })
  }

  modify(id: number) {
    this.flagForm = true
    this.service.getEnterpriseById(id + "")
      .subscribe(res => {
        this.entAct = res
      })

  }

  saveModify() {
    this.entAct.entModifiedBy = 'admin'
    let dateModify: Date = new Date();
    this.entAct.entModifiedDate = dateModify
    this.service.save(this.entAct).subscribe(
      res => {
        this.router.navigate(['/enterprise'])
        this.listEnterpise()
        this.entAct.entName = ''
        this.entAct.entAddress = ''
        this.entAct.entPhone = ''
        this.entAct.entStatus = false
        this.flagForm = false
      }
    )
  }

  mainMenu() {
    this.router.navigate(["main-menu"], { queryParams: { role: 'admin' } })
  }
}
