import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-customer-create',
  templateUrl: './customer-create.component.html',
  styleUrls: ['./customer-create.component.css']
})
export class CustomerCreateComponent implements OnInit {
  checkBoolean=true;
   createCustomer: FormGroup;
  constructor() {
    this.createCustomer =new FormGroup({
      customerId: new FormControl(''),
      customerName: new FormControl('',Validators.required),
      birthday : new FormControl('',Validators.required),
      customerCode: new FormControl('',Validators.pattern('^\\KH[0-9]{4}$')),
      gender: new FormControl('',Validators.required),
      idCart: new FormControl('',Validators.required),
      phone: new FormControl('',[Validators.pattern('^090\\d{7}|\\(84\\)\\+90\\d{7}|091\\d{7}|\\(84\\)\\+91\\d{7}$'),
        Validators.required]),
      email: new FormControl('',[Validators.email,Validators.required]),
      address: new FormControl('',Validators.required),
      customerTypeId: new FormControl('')
    })
  }

  ngOnInit(): void {
  }

  get customerName() {
    return this.createCustomer.get('customerName');
  }
  addCustomer(){
    console.log(this.createCustomer.value);
    this.checkBoolean=false;
  }
}
