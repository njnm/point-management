import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { PointManagementService } from '../point-management.service';
import { Points } from 'src/app/models/points.model';

@Component({
  selector: 'list-point',
  templateUrl: './list-point.component.html',
  styles: ['./list-point.component.css']
})
export class ListPointsComponent implements OnInit {

  points: Points[] = [];

  constructor(private router: Router, private pointManagementService: PointManagementService) {

  }
  
  ngOnInit() {
    this.pointManagementService.getPoints().
    subscribe((response : any) => {
      this.points = response.result;
    }, (err) => {

    })
  };

  deletePoint(id, index) {
    this.pointManagementService.deletePoint(id).
    subscribe((response : any) => {
      this.points.splice(index,1);
      alert("Point deleted successfully");
    }, (err)=> {

    })
  }


}


