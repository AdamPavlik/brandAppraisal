import { Component, OnInit } from '@angular/core';
import { LayoutService, User } from '../service/LayoutService';

@Component({
  selector: 'layout',
  templateUrl: './layout.component.html',
  styleUrls: ['./layout.component.css']
})
export class LayoutComponent implements OnInit {

  user: User;

  constructor(private layoutService: LayoutService) { }

  ngOnInit() {
    this.layoutService.getUser().subscribe(u => this.user = u);
  }

}
