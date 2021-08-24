import {Component, OnInit} from '@angular/core';
import {IService} from "../../interface/iservice";
import {IServiceType} from "../../interface/iservice-type";
import {IRentType} from "../../interface/IRentType";

@Component({
  selector: 'app-service-list',
  templateUrl: './service-list.component.html',
  styleUrls: ['./service-list.component.css']
})
export class ServiceListComponent implements OnInit {
  service: Array<IService> = [{
    serviceId: 1,
    serviceName: 'Núi ngược',
    serviceArea: 1000,
    serviceCode: 'DV-1010',
    serviceCost: 1010111,
    maxPeople: 10,
    standardRoom: 'Thoáng mát',
    description: 'Có Onsen',
    poolArea: 100,
    numberFloors: 1,
    rentTypeId: 1,
    serviceTypeId: 1
  }, {
    serviceId: 2,
    serviceName: 'Ngắm Ngắm',
    serviceArea: 1000,
    serviceCode: 'DV-1011',
    serviceCost: 1010111,
    maxPeople: 10,
    standardRoom: '5*',
    description: 'Massage',
    poolArea: 100,
    numberFloors: 1,
    rentTypeId: 2,
    serviceTypeId: 2
  }];
  rentType: Array<IRentType> = [{
    rentTypeId: 1, rentTypeName: 'Thuê theo năm', rentTypeCost: 10000
  }, {
    rentTypeId: 2, rentTypeName: 'Thuê theo Tháng', rentTypeCost: 1000
  }, {
    rentTypeId: 1, rentTypeName: 'Thuê theo Ngày', rentTypeCost: 100
  }];
  serviceType: Array<IServiceType> = [{
    serviceTypeId: 1, serviceTypeName: 'Đi Cùng Em'
  }, {
    serviceTypeId: 1, serviceTypeName: 'Em Đi Cùng'
  }]

  constructor() {
  }

  ngOnInit(): void {
  }

}
