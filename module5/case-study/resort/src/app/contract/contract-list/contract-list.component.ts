import {Component, OnInit} from '@angular/core';
import {IContract} from "../../interface/icontract";

@Component({
  selector: 'app-contract-list',
  templateUrl: './contract-list.component.html',
  styleUrls: ['./contract-list.component.css']
})
export class ContractListComponent implements OnInit {
  contract: Array<IContract> = [{
    contractId: 1,
    contractDeposit: 1021,
    contractEndDate: '2020/11/11',
    contractStartDate: '2020/11/01',
    contractTotalMoney: 1000000,
    serviceId: 1,
    customerId: 1,
    employeeId: 1
  }, {
    contractId: 2,
    contractDeposit: 1021,
    contractEndDate: '2020/11/11',
    contractStartDate: '2020/11/01',
    contractTotalMoney: 1000000,
    serviceId: 2,
    customerId: 2,
    employeeId: 2
  }]

  constructor() {
  }

  ngOnInit(): void {
  }

}
