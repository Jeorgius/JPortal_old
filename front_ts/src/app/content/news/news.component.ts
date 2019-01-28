import { Component, OnInit } from '@angular/core';
import {DisplayService} from "../../../services/display.service";

@Component({
  selector: 'app-news',
  templateUrl: './news.component.html',
  styleUrls: ['./news.component.scss']
})
export class NewsComponent implements OnInit {

  constructor(private NewsComing: DisplayService ) { }

  public news = [];

  ngOnInit() {
    this.NewsComing.getNews().subscribe(data => this.news = data);
  }

}
