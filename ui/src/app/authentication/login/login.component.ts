import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../../auth/AuthService';
import { LocalStorageService } from '../../commons/localStorage';
import { environment } from '../../../environments/environment';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm : FormGroup;

  constructor(private fb: FormBuilder,
              private auth: AuthService,
              private storage: LocalStorageService,
              private router: Router) {
    this.createForm(fb);
  }


  ngOnInit() {
  }

  logInSubmit() {
    this.auth.login(this.loginForm.get("login").value, this.loginForm.get("password").value)
        .subscribe(sub => {
          this.storage.save(environment.TOKEN_NAME, sub.access_token);
          this.router.navigateByUrl('/')
        })
  }

  createForm(fb: FormBuilder) {
    this.loginForm = fb.group({
      login: ['', Validators.required ],
      password: ['', Validators.required ]
    });
  }

}
