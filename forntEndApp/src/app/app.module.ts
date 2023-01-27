import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { MainMenuComponent } from './main-menu/main-menu.component';
import { DepartmentComponent } from './department/department.component';
import { EnterpriseComponent } from './enterprise/enterprise.component';
import { EmployeeComponent } from './employee/employee.component';
import { ReactiveFormsModule } from '@angular/forms'
import { FormsModule } from '@angular/forms'
import { ServiceEnterpriseService } from './service/service-enterprise.service';
import { HttpClientModule } from '@angular/common/http'
import { ServiceDepartmentService } from './service/service-department.service';
import { ServiceEmployeeService } from './service/service-employee.service';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    MainMenuComponent,
    DepartmentComponent,
    EnterpriseComponent,
    EmployeeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    ServiceEnterpriseService,
    ServiceDepartmentService,
    ServiceEmployeeService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
