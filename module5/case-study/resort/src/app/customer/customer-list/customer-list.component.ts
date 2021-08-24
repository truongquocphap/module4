import { Component, OnInit } from '@angular/core';
import {ICustomer} from "../icustomer";
import {ICustomerType} from "../../customer-type/icustomer-type";

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {
  customers: Array<ICustomer>=[{
    customerId: 1,customerName: 'PhapCP',birthday: '1111-11-11',customerCode: 'KH-1111',gender: 1,idCart: '00000',phone: '090000',email: 'phapcp@gmail.com',address: 'Qang ngai',customerTypeId : 2
  },
    {
      customerId: 2,customerName: 'PhapCP',birthday: '1111-11-11',customerCode: 'KH-1111',gender: 1,idCart: '00000',phone: '090000',email: 'phapcp@gmail.com',address: 'Qang ngai',customerTypeId: 2
    }];
  customerType: Array<ICustomerType>=[
    {
      customerTypeId: 1,customerTypeName: 'Vip'
    },
    {
      customerTypeId: 2,customerTypeName: 'Diamond'
    }
  ]
  constructor() { }

  ngOnInit(): void {
  }

}
