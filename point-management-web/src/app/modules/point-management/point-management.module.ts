import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

import { PointManagementComponent } from './point-management.component';
import { ListPointsComponent } from './list/list-point.component';
import { AddPointsComponent } from './add/add-point.component';
import { PointManagementService } from './point-management.service';
import { PointManagementRouting } from './point-management.routing';

@NgModule({
  declarations: [
    PointManagementComponent,
    AddPointsComponent,
    ListPointsComponent
  ],
  imports: [
    PointManagementRouting,
    CommonModule,
    FormsModule
  ],
  providers: [PointManagementService],
})
export class PointMangementModule { }
