import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'block-adder',
  templateUrl: './block-adder.component.html',
  styleUrls: ['./block-adder.component.scss']
})
export class BlockAdderComponent implements OnInit {

  @Input() toDisplay : string[] = [
    "media",
    "text",
    "mediaLeft",
    "mediaRight"
  ];
  @Output() blockType :EventEmitter<string> = new EventEmitter();

  constructor() { }
  ngOnInit() {}

  emitBlockType(blockType:string){
    this.blockType.emit(blockType);
  }

}
