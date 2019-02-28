import { Component, OnInit } from '@angular/core';
import {newsList} from "../../content/interfaces/displayContent";
import {NewsItem} from "../../entities/News";
import {FileSystemFileEntry, UploadEvent, UploadFile} from "ngx-file-drop";

@Component({
  selector: 'app-news-creator',
  templateUrl: './news-creator.component.html',
  styleUrls: ['./news-creator.component.scss']
})
export class NewsCreatorComponent implements OnInit {

  public newsItem :newsList = new NewsItem("New Title", null, "Enter text here");
  public files :UploadFile[] = [];

  constructor() { }

  ngOnInit() {
  }

  drag_n_drop(event :UploadEvent){
    this.files = event.files;

    for(let newFile of event.files){
      let fileEntry = newFile.fileEntry as FileSystemFileEntry;
      fileEntry.file((file :File) => {
        alert(newFile.relativePath);
      })
    }
  }
}
