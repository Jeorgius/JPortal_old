import {Component, Input, OnInit} from '@angular/core';
// import svg from './creator.svg';

@Component({
  selector: 'svg-icon',
  templateUrl: './svg-icon.component.html',
  styleUrls: ['./svg-icon.component.scss']
})
export class SvgIconComponent implements OnInit {

  /**
   * Display SVG-icon based on icon name
   * ("id" in assets/data/creator.svg)
   */
  @Input() icon :string;

  constructor() {}

  ngOnInit() {}

}
