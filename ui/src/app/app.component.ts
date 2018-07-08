import { Component, OnInit } from '@angular/core';
import { AuthService } from './auth/AuthService';
import { Router } from '@angular/router';
import { LocalStorageService } from './commons/localStorage';
import { environment } from '../environments/environment';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{

  constructor(private router: Router,
              private auth: AuthService,
              private storage: LocalStorageService) {
  }

  ngOnInit(): void {
    let token = this.storage.get(environment.TOKEN_NAME)
    if(token !== null){
        this.auth.checkToken(token).subscribe(() => {}, () => {
          this.storage.remove(environment.TOKEN_NAME);
          window.location.href = '/';
        });
    }
  }


}
