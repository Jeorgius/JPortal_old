import { Component, OnInit } from '@angular/core';
import {DisplayService} from "../../../services/display.service";

@Component({
  selector: 'app-photos',
  templateUrl: './photos.component.html',
  styleUrls: ['./photos.component.scss']
})
export class PhotosComponent implements OnInit {

  constructor(private PhotosComing: DisplayService ) { }
  public Photos = [];

  ngOnInit() {
    this.PhotosComing.getPhotos().subscribe(data => this.Photos = data);
  }

}
