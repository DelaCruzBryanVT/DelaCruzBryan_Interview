import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DepartmentComponent } from './department/department.component';
import { EmployeeComponent } from './employee/employee.component';
import { EnterpriseComponent } from './enterprise/enterprise.component';
import { LoginComponent } from './login/login.component';
import { MainMenuComponent } from './main-menu/main-menu.component';

const routes: Routes = [
  { path: '', component: LoginComponent },
  { path: 'main-menu', component: MainMenuComponent },
  { path: 'enterprise', component: EnterpriseComponent },
  { path: 'department', component: DepartmentComponent },
  { path: 'employee', component: EmployeeComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
