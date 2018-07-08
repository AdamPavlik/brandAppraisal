import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../../auth/AuthService';
import { environment } from '../../../environments/environment';
import { LocalStorageService } from '../../commons/localStorage';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  registrationForm : FormGroup;

  hide: boolean = true;

  constructor(private fb: FormBuilder,
              private authService: AuthService,
              private storage: LocalStorageService) {
    this.createForm(fb);
  }


  ngOnInit() {
  }

  //todo errors and validations
  signUpSubmit() {
    let user =  {
      id: null,
      firstName : this.registrationForm.get('firstName').value,
      secondName : this.registrationForm.get('lastName').value,
      phoneNumber: this.registrationForm.get('phoneNumber').value,
      email: this.registrationForm.get('email').value,
      password: this.registrationForm.get('password').value
    };
    this.authService.registration(user).subscribe(userId => {
      let pass = user.password;
      user.id = userId;
      user.password = null;
      this.storage.save(environment.current_user_key, user);
      this.authService.login(user.email, pass).subscribe(sub => {
        this.storage.save(environment.TOKEN_NAME, sub.access_token);
        window.location.href = '/';
      })
    }, error => {

    })
  }

  createForm(fb: FormBuilder) {
    this.registrationForm = fb.group({
      firstName: ['', Validators.required ],
      lastName: ['', Validators.required ],
      email: ['', Validators.required,  ],
      phoneNumber: ['', Validators.required],
      password: ['', Validators.required ]
    });
  }

}
