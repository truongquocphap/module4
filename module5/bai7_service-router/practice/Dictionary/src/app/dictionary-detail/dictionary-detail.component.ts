import { Component, OnInit } from '@angular/core';
import {DictionaryService} from "../service/dictionary.service";
import {IWord} from "../module/iword";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-dictionary-detail',
  templateUrl: './dictionary-detail.component.html',
  styleUrls: ['./dictionary-detail.component.css']
})
export class DictionaryDetailComponent implements OnInit {
  meaning: IWord;
  constructor(private dictionaryService: DictionaryService,
              private activatedRoute : ActivatedRoute) {
  }

  ngOnInit(): void {
    const w=this.activatedRoute.snapshot.paramMap.get('word');
   this.meaning= this.dictionaryService.findByWord(w);

  }

}
