import { Component, OnInit } from '@angular/core';
//import * as mapboxgl from 'mapbox-gl';
import * as mgl from 'ngx-mapbox-gl';
// import {ControlComponent} from "ngx-mapbox-gl";

@Component({
  selector: 'app-model3d',
  templateUrl: './model3d.component.html',
  styleUrls: [
    './model3d.component.scss'
  ]
})
export class Model3dComponent implements OnInit {

  public centerXY =[

    30.319943, 59.963848 // Piter
  ];

  public myWay = [[-122.48369693756104, 37.83381888486939],
    [-122.48348236083984, 37.83317489144141],
    [-122.48339653015138, 37.83270036637107],
    [-122.48356819152832, 37.832056363179625],
    [-122.48404026031496, 37.83114119107971],
    [-122.48404026031496, 37.83049717427869],
    [-122.48348236083984, 37.829920943955045],
    [-122.48356819152832, 37.82954808664175],
    [-122.48507022857666, 37.82944639795659],
    [-122.48610019683838, 37.82880236636284],
    [-122.48695850372314, 37.82931081282506],
    [-122.48700141906738, 37.83080223556934],
    [-122.48751640319824, 37.83168351665737],
    [-122.48803138732912, 37.832158048267786],
    [-122.48888969421387, 37.83297152392784],
    [-122.48987674713133, 37.83263257682617],
    [-122.49043464660643, 37.832937629287755],
    [-122.49125003814696, 37.832429207817725],
    [-122.49163627624512, 37.832564787218985],
    [-122.49223709106445, 37.83337825839438],
    [-122.49378204345702, 37.83368330777276]];

  public data = {
    'type': 'Feature',
    'properties': {},
    'layout':{
      'line-join': 'round',
      'line-cap': 'round'
    },
    'paint': {
      'line-color': '#FF0000',
      'line-width': '8'
    },
    'geometry': {
      'type': 'LineString',
      'coordinates': [
        [30.319943, 59.963848],
        [30.319950, 59.963848],
        [30.319970, 59.963848]
      ]
    }
  };
  // private adminToken = "sk.eyJ1IjoiamVvcmdpdXMiLCJhIjoiY2pzc3ZiZHcyMWNwMTN5bXo3anQ2Zmt4dCJ9.IwmNn-ya-SWGps7N37mdYw";
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
