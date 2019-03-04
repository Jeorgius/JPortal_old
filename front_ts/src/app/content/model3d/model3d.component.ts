import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-model3d',
  templateUrl: './model3d.component.html',
  styleUrls: ['./model3d.component.scss']
})
export class Model3dComponent implements OnInit {

  private adminToken = "sk.eyJ1IjoiamVvcmdpdXMiLCJhIjoiY2pzc3ZiZHcyMWNwMTN5bXo3anQ2Zmt4dCJ9.IwmNn-ya-SWGps7N37mdYw";
  constructor() { }

  ngOnInit() {
    let lMap = L.map('mapid').setView([59.963848, 30.319943],13);
    L.tileLayer('https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token='+this.adminToken, {
      attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors, <a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
      maxZoom: 18,
      id: 'mapbox.streets',
      accessToken: 'your.mapbox.access.token'
    }).addTo(lMap);
  }

}
