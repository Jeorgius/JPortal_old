import { Component, OnInit } from '@angular/core';
import { DisplayService} from "../../services/display.service";

@Component({
  selector: 'app-music',
  templateUrl: './music.component.html',
  styleUrls: ['./music.component.scss']
})
export class MusicComponent implements OnInit {

  constructor(private MusicComing: DisplayService) { }

  public Music = [];

  ngOnInit() {
    this.MusicComing.getMusic().subscribe(data => this.Music = data);
  }

}
