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
  public files :File[] = [];

  constructor() { }

  ngOnInit() {
    this.preventDefaultRerouts();
  }

  drag_n_drop(files :File[]){
    alert("Yes");
    this.files = files;

    for(let newFile of files){
        alert(newFile.name);
    }
  }

  private preventDefaultRerouts(){
    //prevent rerouts to picture view when dropping image to an ImageArea
    let imageAreas = document.getElementsByClassName("ImageField"),
      Events = ['dragenter', 'dragover' , 'dragleave', 'drop'];

    for(let i=0; i<imageAreas.length;i++){
      for(let event of Events){
        imageAreas[i].addEventListener(event, (event) => {
          event.preventDefault();
          event.stopPropagation();
        })
      }
    }

    return imageAreas;
  }
}
