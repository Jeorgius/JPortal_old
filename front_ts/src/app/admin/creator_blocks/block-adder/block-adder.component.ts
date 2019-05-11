import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'block-adder',
  templateUrl: './block-adder.component.html',
  styleUrls: ['./block-adder.component.scss']
})
export class BlockAdderComponent implements OnInit {

  /**
   * Default array of svg's to display
   * To display own set of svg components, set array as input and
   * fill it with elements from assets/data/creator.svg
   */
  @Input() toDisplay : string[] = [
    "mediaOnly",
    "textOnly",
    "mediaLeft",
    "mediaRight"
  ];

  @Output() blockType :EventEmitter<string> = new EventEmitter();

  constructor() { }
  ngOnInit() {}

  /**
   * Click on svg-block
   * @param blockType - name of icon that user clicked on
   * emits string with icon name to be transformed into component name
   */
  emitBlockType(blockType:string){
    this.blockType.emit(blockType);
  }

}
