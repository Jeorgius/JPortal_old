import { Component, OnInit } from '@angular/core';
import {newsList} from "../../content/interfaces/displayContent";
import {NewsItem} from "../../entities/News";

@Component({
  selector: 'app-news-creator',
  templateUrl: './news-creator.component.html',
  styleUrls: ['./news-creator.component.scss']
})
export class NewsCreatorComponent implements OnInit {

  public newsItem :newsList = new NewsItem("New Title", "URL", "Enter text here");

  constructor() { }

  ngOnInit() {
  }

}
