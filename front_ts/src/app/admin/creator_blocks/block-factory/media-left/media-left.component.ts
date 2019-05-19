import { Component, OnInit } from '@angular/core';
import {Block} from "../block";

@Component({
  selector: 'app-media-left',
  templateUrl: './media-left.component.html',
  styleUrls: ['./media-left.component.scss']
})
export class MediaLeftComponent implements OnInit, Block {

  index: number;
  constructor() { }

  ngOnInit() {
  }

}
