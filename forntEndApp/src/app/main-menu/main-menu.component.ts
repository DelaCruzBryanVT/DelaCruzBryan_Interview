import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-main-menu',
  templateUrl: './main-menu.component.html',
  styleUrls: ['./main-menu.component.css']
})
export class MainMenuComponent implements OnInit {

  role: string = '';

  constructor(private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.queryParams.subscribe((params: any) => { this.role = params.role; });
  }

  logout() {
    this.router.navigate([""])
    this.role = ''
  }

  department() {
    this.router.navigate(["department"])
    this.role = ''
  }
  enterprise() {
    this.router.navigate(["enterprise"])
    this.role = ''
  }
  employee() {
    this.router.navigate(["employee"])
    this.role = ''
  }
}
