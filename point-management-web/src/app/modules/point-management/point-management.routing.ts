import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PointManagementComponent } from './point-management.component';
import { AddPointsComponent } from './add/add-point.component';
import { ListPointsComponent } from './list/list-point.component';


const routes: Routes = [
  { path: '', component: PointManagementComponent, 
    children: [
      { path: '', pathMatch: 'full', redirectTo: 'list' },
      { path: 'add', component: AddPointsComponent },
      { path: 'list', component: ListPointsComponent }
    ]},
];

@NgModule({
  imports: [
    RouterModule.forChild(routes)
  ],
  exports: [
    RouterModule
  ],
  declarations: []
})
export class PointManagementRouting { }
