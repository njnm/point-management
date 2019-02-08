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

  locationTypes = ["EE", "FI", "LI"];

  selectedLocation : string = "EE";

  constructor(private router: Router, private pointManagementService: PointManagementService) {

  }
  
  ngOnInit() {
    this.getPoints('EE');
  };

  getPoints(location){
    this.pointManagementService.getPoints(location).
    subscribe((response : any) => {
      this.points = response.result;
    }, (err) => {
      alert("Failed to load Points. Please try again")
    })
  }

  deletePoint(id, index) {
    this.pointManagementService.deletePoint(id).
    subscribe((response : any) => {
      this.points.splice(index,1);
      alert("Point deleted successfully");
    }, (err)=> {

    })
  }


}


