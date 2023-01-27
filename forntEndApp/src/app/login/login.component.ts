import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  flag: boolean = true
  form!: FormGroup

  users: any = [
    {
      user: 'admin',
      password: 'root',
      role: 'admin'
    },
    {
      user: 'emp',
      password: '1234',
      role: 'emp'
    },
  ]

  constructor(private router: Router) {
    this.buildForm()
  }

  ngOninit() { }

  private buildForm() {
    this.form = new FormGroup({
      user: new FormControl('', [Validators.required]),
      password: new FormControl('', [Validators.required])

    })
  }

  login() {
    if (this.form.value.user === 'admin' && this.form.value.password === 'root') {
      this.router.navigate(["main-menu"], { queryParams: { role: 'admin' } })
    }
    else if (this.form.value.user === 'emp' && this.form.value.password === '1234') (
      this.router.navigate(["main-menu"], { queryParams: { role: 'emp' } })
    )
    else {
      this.router.navigate([""])
      this.flag = false;
    }
  }
}
