import { Component, OnInit } from '@angular/core';
import {DisplayService} from "../../services/display.service";

@Component({
  selector: 'app-store',
  templateUrl: './store.component.html',
  styleUrls: ['./store.component.scss']
})
export class StoreComponent implements OnInit {

  constructor( private ProductsComing: DisplayService) { }

  public Products = [];

  ngOnInit() {
    this.ProductsComing.getItems().subscribe(data => this.Products = data);
  }

}
