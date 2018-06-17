import { Component, OnInit } from '@angular/core';
import { LayoutService, User } from '../service/LayoutService';
import { Router } from '@angular/router';

@Component({
  selector: 'layout',
  templateUrl: './layout.component.html',
  styleUrls: ['./layout.component.css']
})
export class LayoutComponent implements OnInit {

  user: User;

  constructor(private layoutService: LayoutService,
              private router: Router) { }

  ngOnInit() {
  }

  login() {
    this.router.navigateByUrl("/login")
  }

  registration() {
    this.router.navigateByUrl("/registration")
  }

}
