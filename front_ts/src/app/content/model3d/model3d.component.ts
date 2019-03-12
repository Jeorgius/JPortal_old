import { Component, OnInit } from '@angular/core';
//import * as mapboxgl from 'mapbox-gl';
// import * as mgl from 'ngx-mapbox-gl';
// import {ControlComponent} from "ngx-mapbox-gl";

@Component({
  selector: 'app-model3d',
  templateUrl: './model3d.component.html',
  styleUrls: [
    './model3d.component.scss'
  ]
})
export class Model3dComponent implements OnInit {

  private adminToken = "sk.eyJ1IjoiamVvcmdpdXMiLCJhIjoiY2pzc3ZiZHcyMWNwMTN5bXo3anQ2Zmt4dCJ9.IwmNn-ya-SWGps7N37mdYw";
  constructor() { }

  ngOnInit() {
    //Mapbox
    //mapboxgl.accessToken = 'pk.eyJ1IjoiamVvcmdpdXMiLCJhIjoiY2pzc3Y3Z3JiMTE1YzQzbzRlb3ZmNWJrdSJ9.jFPt7wpDWHkkXqzcSbwQzA';
    // let mMap = new mapboxgl.Map({
    //   container: 'mapid',
    //   style: 'mapbox://styles/mapbox/streets-v9',
    //
    //   //Chicago
    //   // center: [-87.61694, 41.86625],
    //
    //   //Saint-Petersburg
    //   center: [30.319943, 59.963848],
    //
    //   //Paris
    //   //center: [48.856663, 2.351556],
    //   zoom: 15.99,
    //   pitch: 40,
    //   bearing: 20
    // });
    // mMap.addControl(new mapboxgl.NavigationControl());

    /*mMap.on('load', function() {
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
    });*/

    //   mMap.on('load', function() {
    //     // Insert the layer beneath any symbol layer.
    //     let layers = mMap.getStyle().layers;
    //
    //     let labelLayerId;
    //     for (let i = 0; i < layers.length; i++) {
    //       if (layers[i].type === 'symbol' && layers[i].layout['text-field']) {
    //         labelLayerId = layers[i].id;
    //         break;
    //       }
    //     }
    //
    //     mMap.addLayer({
    //       'id': '3d-buildings',
    //       'source': 'composite',
    //       'source-layer': 'building',
    //       'filter': ['==', 'extrude', 'true'],
    //       'type': 'fill-extrusion',
    //       'minzoom': 15,
    //       'paint': {
    //         'fill-extrusion-color': '#aaa',
    //
    //         // use an 'interpolate' expression to add a smooth transition effect to the
    //         // buildings as the user zooms in
    //         'fill-extrusion-height': [
    //           "interpolate", ["linear"], ["zoom"],
    //           15, 0,
    //           15.05, ["get", "height"]
    //         ],
    //         'fill-extrusion-base': [
    //           "interpolate", ["linear"], ["zoom"],
    //           15, 0,
    //           15.05, ["get", "min_height"]
    //         ],
    //         'fill-extrusion-opacity': .6
    //       }
    //     }, labelLayerId);
    //   });
    // }
  }
}
