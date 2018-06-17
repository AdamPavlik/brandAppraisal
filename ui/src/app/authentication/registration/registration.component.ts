import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  registrationForm : FormGroup;

  constructor(private fb: FormBuilder) {
    this.createForm(fb);
  }


  ngOnInit() {
  }

  signUpSubmit() {
    console.log("sign up")
  }

  createForm(fb: FormBuilder) {
    this.registrationForm = fb.group({
      firstName: ['', Validators.required ],
      lastName: ['', Validators.required ],
      email: ['', Validators.required ],
      password: ['', Validators.required ]
    });
  }

}
