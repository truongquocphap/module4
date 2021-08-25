import { Component, OnInit } from '@angular/core';
import { Todo } from "../todo";
import {FormControl} from "@angular/forms";
let id=1;
@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent implements OnInit {
  todos: Todo[] = [];
  content = new FormControl();
  toggleTodo(i: number){
    this.todos[i].complete=!this.todos[i].complete;
  }
  change(){
    const value=this.content.value;
    if (value){
      const todo: Todo= {
        id: id++,
        content: value,
        complete: false
      };
      this.todos.push(todo)
      this.content.reset();
    }
  }
  constructor() { }

  ngOnInit(): void {
  }

}
