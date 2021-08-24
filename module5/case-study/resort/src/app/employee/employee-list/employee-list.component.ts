import { Component, OnInit } from '@angular/core';
import {Idivision} from "../../interface/idivision";
import {IPosition} from "../../interface/iposition";
import {Ieducation} from "../../interface/ieducation";
import {Iemployee} from "../../interface/iemployee";

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {
  employee: Array<Iemployee>= [{
    employeeId: 1,employeeName: 'ChauCP',birthday: '1111-11-11',employeeIdCart: '10010101',employeeSalary: 100000,employeePhone: '0911111'
    ,employeeAddress: 'Da Nang',employeeEmail:'Chau@gmail.com',positionId: 1,divisionEmployeeId:1,educationEmployeeId:1
  },{
    employeeId: 2,employeeName: 'ChauCP',birthday: '1111-11-11',employeeIdCart: '10010101',employeeSalary: 100000,employeePhone: '0911111'
    ,employeeAddress: 'Da Nang',employeeEmail:'Chau@gmail.com',positionId: 2,divisionEmployeeId:1,educationEmployeeId:2
  }];
  education: Array<Ieducation> =[{
    educationId: 1,educationName:'Đại học'
  },{
    educationId: 2,educationName:'Trung Cấp'
  }];
  division: Array<Idivision> =[{
    divisionId:1,divisionName: 'Bảo Quản Kho'
  },{
    divisionId:2,divisionName: 'Quản Lý công nhân'
  }]
  position: Array<IPosition>=[{
    positionId: 1,positionName:'Quản Kho'
  },{
    positionId: 2,positionName:'Quản Lý'
  }]
  constructor() {
  }

  ngOnInit(): void {
  }

}
