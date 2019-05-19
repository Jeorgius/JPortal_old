import { Component, OnInit } from '@angular/core';
import {Block} from "../block";

@Component({
  selector: 'app-media-right',
  templateUrl: './media-right.component.html',
  styleUrls: ['./media-right.component.scss']
})
export class MediaRightComponent implements OnInit, Block {
  index: number;

  constructor() {}

  ngOnInit() {}

}
