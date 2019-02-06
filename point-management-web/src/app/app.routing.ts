import { Routes } from '@angular/router';

export const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'points' },
  { path: 'points', loadChildren: "./modules/point-management/point-management.module#PointMangementModule" }
];


