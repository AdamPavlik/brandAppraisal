import { Component, OnInit } from '@angular/core';
import { LayoutService, User } from '../service/LayoutService';
import { Router } from '@angular/router';
import { AuthService } from '../../auth/AuthService';
import { NotificationService } from '../notifications/NotificationService';

@Component({
  selector: 'layout',
  templateUrl: './layout.component.html',
  styleUrls: ['./layout.component.css']
})
export class LayoutComponent implements OnInit {

  user: User;

  constructor(private layoutService: LayoutService,
              private authService: AuthService,
              private router: Router) { }

  ngOnInit() {
  }

  login() {
    this.router.navigateByUrl("/login")
  }

  logout(){
    this.authService.logout();
  }

  registration() {
    this.router.navigateByUrl("/registration")
  }

}
