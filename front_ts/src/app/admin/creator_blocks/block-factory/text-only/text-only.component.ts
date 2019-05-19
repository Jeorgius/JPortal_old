import { Component, OnInit } from '@angular/core';
import {Block} from "../block";

@Component({
  selector: 'app-text-only',
  templateUrl: './text-only.component.html',
  styleUrls: ['./text-only.component.scss']
})
export class TextOnlyComponent implements OnInit, Block {
  index: number;

  constructor() { }

  ngOnInit() {
  }

}
