import { Injectable } from '@angular/core';
import {IWord} from "../module/iword";

@Injectable({
  providedIn: 'root'
})
export class DictionaryService {

  constructor() {}
  dictionary: IWord[]= [{
    word: 'number',
    meaning: 'biểu hiện của số '
  },{
    word: 'count',
    meaning: 'biểu hiển cho đếm'
  },
    {
      word: 'sum',
      meaning: 'biểu hiện cho tính tổng'
    }];
  findByWord(word: string){
    for (let i = 0; i < this.dictionary.length; i++) {
      if (this.dictionary[i].word==word){
        return this.dictionary[i];
      }
    }
    return null;
  }
  getAll(){
    return this.dictionary;
  }
}
