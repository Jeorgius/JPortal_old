import { Component, OnInit } from '@angular/core';
import {newsList} from "../../content/interfaces/displayContent";
import {NewsItem} from "../../entities/News";
import {of} from "rxjs/internal/observable/of";

@Component({
  selector: 'app-news-creator',
  templateUrl: './news-creator.component.html',
  styleUrls: ['./news-creator.component.scss']
})
export class NewsCreatorComponent implements OnInit {

  public newsItem = new NewsItem("New Title", "Enter text here");
  public files :File[] = [];

  constructor() { }

  ngOnInit() {}

  drag_n_drop(files :File[]){
    //alert("Yes");
    this.files = files;
    this.newsItem.pic = this.files[0];

  }

  checkname(){
    alert(this.newsItem.pic.name);
  }
}
