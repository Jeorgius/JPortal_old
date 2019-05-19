import { Component, OnInit } from '@angular/core';
import {Block} from "../block";

@Component({
  selector: 'app-media-only',
  templateUrl: './media-only.component.html',
  styleUrls: ['./media-only.component.scss']
})
export class MediaOnlyComponent implements OnInit, Block {

  index: number;

  constructor() { }
  ngOnInit() {
  }

}
