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
    //LEAFLET
    // let lMap = L.map('mapid').setView([59.963848, 30.319943],13);
    // L.tileLayer('https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token='+this.adminToken, {
    //   attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors, <a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
    //   maxZoom: 18,
    //   id: 'mapbox.streets',
    //   accessToken: 'your.mapbox.access.token'
    // }).addTo(lMap);

    //WRLD3D
    // let eMap = L.Wrld.map('mapid', '269194e12fdedd29d1bee4767e1aee2c', {
    //   // center: [59.963848, 30.319943],
    //   center: [40.720347, -74.002010],
    //   zoom: 15
    // });
  //   L.tileLayer('https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token='+this.adminToken, {
  //       attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors, <a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
  //       maxZoom: 18,
  //       id: 'mapbox.streets',
  //       accessToken: 'your.mapbox.access.token'
  //     }).addTo(eMap);

    //Mapbox
    mapboxgl.accessToken = 'pk.eyJ1IjoiamVvcmdpdXMiLCJhIjoiY2pzc3Y3Z3JiMTE1YzQzbzRlb3ZmNWJrdSJ9.jFPt7wpDWHkkXqzcSbwQzA';
    let mMap = new mapboxgl.Map({
      container: 'mapid',
      style: 'mapbox://styles/mapbox/streets-v9',

      //Chicago
      // center: [-87.61694, 41.86625],

      //Saint-Petersburg
      center: [30.319943, 59.963848],

      //Paris
      //center: [48.856663, 2.351556],
      zoom: 15.99,
      pitch: 40,
      bearing: 20
    });
    mMap.addControl(new mapboxgl.NavigationControl());

    mMap.on('load', function() {
      mMap.addLayer({
        'id': 'room-extrusion',
        'type': 'fill-extrusion',
        'source': {
    // GeoJSON Data source used in vector tiles, documented at
    // https://gist.github.com/ryanbaumann/a7d970386ce59d11c16278b90dde094d
          'type': 'geojson',
          'data': 'https://docs.mapbox.com/mapbox-gl-js/assets/indoor-3d-map.geojson'
        },
        'paint': {
    // See the Mapbox Style Specification for details on data expressions.
    // https://docs.mapbox.com/mapbox-gl-js/style-spec/#expressions

    // Get the fill-extrusion-color from the source 'color' property.
          'fill-extrusion-color': ['get', 'color'],

    // Get fill-extrusion-height from the source 'height' property.
          'fill-extrusion-height': ['get', 'height'],

    // Get fill-extrusion-base from the source 'base_height' property.
          'fill-extrusion-base': ['get', 'base_height'],

    // Make extrusions slightly opaque for see through indoor walls.
          'fill-extrusion-opacity': 0.5
        }
      })
    });

  }

}
