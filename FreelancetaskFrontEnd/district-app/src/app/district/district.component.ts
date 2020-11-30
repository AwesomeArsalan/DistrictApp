import { Component, OnInit } from '@angular/core';
import { District } from '../Model/District';
import { Circle } from '../Model/Circle';
import { DistrictService } from '../service/district-service.service';

@Component({
  selector: 'app-district',
  templateUrl: './district.component.html',
  styleUrls: ['./district.component.css']
})
export class DistrictComponent implements OnInit {

  districtSelected = '';
  circleList: Circle[] = [];
  districtList: District[] = [];
  constructor(private districtService: DistrictService) { }

  onDivisionSelect(val: any): void{
    this.districtService.getCircleByDistrictName(val).subscribe( data => {
      console.log(data);
      this.circleList = data;
      console.log(this.circleList);
    });
  }

  ngOnInit(): void {
    this.districtService.getDistricts().subscribe( data => {
      console.log(data);
      this.districtList = data;
      this.districtSelected = this.districtList[0].name;
      this.onDivisionSelect(this.districtSelected);
    });
  }

}
