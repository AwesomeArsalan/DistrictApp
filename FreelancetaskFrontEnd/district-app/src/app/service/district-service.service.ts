import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Circle } from '../Model/Circle';
import { District } from '../Model/District';

@Injectable({
  providedIn: 'root'
})
export class DistrictService {

  constructor(private http: HttpClient) { }

  getDistricts(): Observable<Circle[]>{
    const url = 'http://localhost:8080/district';
    return this.http.get<Circle[]>(url);
  }

  getCircleByDistrictName(districtName): Observable<District[]>{
    const url = 'http://localhost:8080/circle/' + districtName;
    return this.http.get<District[]>(url);
  }
}
