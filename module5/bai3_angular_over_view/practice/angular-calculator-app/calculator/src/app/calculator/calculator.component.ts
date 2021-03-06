import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {
  output: string;
  first: number;
  second: number;
  operator: string;

  onFirstChange(value) {

    this.first = Number(value);
  }

  onSecondChange(value) {

    this.second = Number(value);
  }

  onSelectChange(value) {
    this.operator = value;
  }

  calculator() {
    switch (this.operator) {
      case '+':
        this.output = (this.first + this.second) + '';
        break;
      case '-':
        this.output = (this.first - this.second) + '';
        break;
      case '*':
        this.output = (this.first * this.second) + '';
        break;
      case '/':
        if (this.second == 0) {
          this.output = 'Không thể chia cho 0';
          break;
        } else {
          this.output = (this.first / this.second) + '';
          break;
        }
    }
  }

  constructor() {
  }

  ngOnInit(): void {
  }

}
