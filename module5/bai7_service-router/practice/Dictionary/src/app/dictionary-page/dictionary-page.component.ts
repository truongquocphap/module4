import {Component, OnInit} from '@angular/core';
import {IWord} from "../module/iword";
import {DictionaryService} from "../service/dictionary.service";

@Component({
  selector: 'app-dictionary-page',
  templateUrl: './dictionary-page.component.html',
  styleUrls: ['./dictionary-page.component.css']
})
export class DictionaryPageComponent implements OnInit {
  wordList: IWord[] = [];

  constructor(private dictionaryService: DictionaryService) {

  }

  ngOnInit(): void {
    this.getAll();
  }

  getAll() {
    this.wordList = this.dictionaryService.getAll();
  }
}
