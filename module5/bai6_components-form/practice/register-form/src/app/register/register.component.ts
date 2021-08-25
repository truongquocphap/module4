import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormControl, FormGroup, Validators} from "@angular/forms";
import {passBoolean} from "protractor/built/util";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  loginForm: FormGroup;

  constructor() {
    this.loginForm = new FormGroup({
      email: new FormControl('', Validators.email),
      checkPassword: new FormGroup({
        password: new FormControl('', [Validators.required, Validators.minLength(6)]),
        confirmPassword: new FormControl('', [Validators.required, Validators.minLength(6)]),
      }, this.confirm),

      country: new FormControl('', Validators.required),
      age: new FormControl('', Validators.min(18)),
      gender: new FormControl('', Validators.required),
      phone: new FormControl('', Validators.pattern('^\\+84\\d{9,10}$'))
    })
  }

  ngOnInit(): void {
  }

  confirm(password: AbstractControl): any {
    const confirmPass = password.value.confirmPassword;
    const pass = password.value.password;

    return confirmPass === pass ? null : {errorPass: true};

  }

  getLoginForm(): void {
    console.log(this.loginForm.value.email)
    this.loginForm = null;
  }
}
