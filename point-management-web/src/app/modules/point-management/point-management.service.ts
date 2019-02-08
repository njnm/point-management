import {Injectable} from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class PointManagementService {

  constructor(private http:HttpClient) {}

  private url = 'http://localhost:8080/points';
  //private userUrl = '/api';

  public getPoints(location) {
    return this.http.get(this.url + `/${location}`);
  }

  public savePoint(point) {
    debugger;
    return this.http.post(this.url, point);
  }

  public deletePoint(id) {
    return this.http.delete(this.url + "?id="+id);
  }
}
