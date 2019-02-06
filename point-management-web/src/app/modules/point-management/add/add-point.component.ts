import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { PointManagementService } from '../point-management.service';
import { Points } from '../../../models/points.model';

@Component({
  selector: 'add-point',
  templateUrl: './add-point.component.html',
  styleUrls: ['./add-point.component.css']
})
export class AddPointsComponent {

  point: Points = new Points();

  constructor(private pointService: PointManagementService) {

  }

  savePoint(point){
    this.pointService.savePoint(point).
    subscribe((response)=>{
      alert("Point saved succesfully");
      this.point = new Points();
      console.log(response);
    }, (err)=> {
      alert(err.message);
    })
  }

}
