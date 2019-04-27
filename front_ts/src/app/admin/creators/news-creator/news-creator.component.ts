import { Component, OnInit } from '@angular/core';
import {NewsItem} from "../../../entities/News";
import {ImageSaverService} from "../../services/image_saver/image-saver.service";

@Component({
  selector: 'app-news-creator',
  templateUrl: './news-creator.component.html',
  styleUrls: ['./news-creator.component.scss']
})
export class NewsCreatorComponent implements OnInit {

  public newsItem = new NewsItem("New Title", "Enter text here");
  public files :File[] = [];
  public message :string;

  constructor(
    private ImageSaver :ImageSaverService
  ) { }

  ngOnInit() {}

  async drag_n_drop(files :File[]){
    this.files = files;
    this.newsItem.pic = this.files[0];

    let message = await this.ImageSaver
      .saveImage(this.files[0])
      .toPromise();
    this.message = message.answer;
  }

  // checkname(){
  //   alert(this.newsItem.pic.name);
  // }
}
