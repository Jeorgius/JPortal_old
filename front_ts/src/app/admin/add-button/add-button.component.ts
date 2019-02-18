import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {CreatorDeterminatorService} from "../services/creator-determinator.service";

@Component({
  selector: 'app-add-button',
  templateUrl: './add-button.component.html',
  styleUrls: ['./add-button.component.scss']
})
export class AddButtonComponent implements OnInit {

  constructor(private GoTo :CreatorDeterminatorService) { }

  ngOnInit() {
  }

  createItem(){
    this.GoTo.goToCreator();
  }
}
