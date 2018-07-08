import { Component, OnInit } from '@angular/core';
import { NotificationService } from '../layout/notifications/NotificationService';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  constructor(private notifications: NotificationService) {

  }

  ngOnInit() {

  }

}
