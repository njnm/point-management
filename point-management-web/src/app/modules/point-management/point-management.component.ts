import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PointManagementService } from './point-management.service';

@Component({
  selector: 'app-points',
  templateUrl: './point-management.component.html'
})
export class PointManagementComponent implements OnInit {

  title = "User App";

  constructor(private userService: PointManagementService, private router : Router){

  }

  ngOnInit() {};

}


