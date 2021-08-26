import { Component, OnInit } from '@angular/core';
import {ICustomer} from "../../interface/icustomer";
import {ICustomerType} from "../../interface/icustomer-type";

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {

  customersList: ICustomer[]=[];
  customerType: ICustomerType[]=[];

  constructor() { }

  ngOnInit(): void {
  }

}
