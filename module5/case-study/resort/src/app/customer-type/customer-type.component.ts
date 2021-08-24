import {Component, Input, OnInit} from '@angular/core';
import {ICustomerType} from "./icustomer-type";

@Component({
  selector: 'app-customer-type',
  templateUrl: './customer-type.component.html',
  styleUrls: ['./customer-type.component.css']
})
export class CustomerTypeComponent implements OnInit {
  @Input()
  customerType: Array<ICustomerType> = [{
    customerTypeId: 1, customerTypeName: 'Thường'
  },
    {
    customerTypeId: 2, customerTypeName: 'Vip'
  },
    {
      customerTypeId: 3, customerTypeName: 'Chuyên gia'
    }];

  constructor() {
  }

  ngOnInit(): void {
  }

}
