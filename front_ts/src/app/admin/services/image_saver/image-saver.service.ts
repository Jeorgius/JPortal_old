import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {iImageSave} from "../interfaces/iImageSave";
import {CookieXSRFStrategy} from "@angular/http";
import {CookieService} from "ngx-cookie-service";

@Injectable({
  providedIn: 'root'
})
export class ImageSaverService {

  private MediaServer = "https://localhost:8007/save_image";
  //private MediaServer = "http://localhost:8002";
  constructor(
    private Http :HttpClient,
    private cookies :CookieService) { }

  saveImage(newFile :File) {
    let formSend = new FormData();
    formSend.append("hero", newFile,"heroTest");
    //alert(this.cookies.get("XSRF-TOKEN"));

    return this.Http.post<iImageSave>(
      this.MediaServer,
      formSend,
      {headers: new HttpHeaders({"X-CSRF-TOKEN": this.cookies.get("XSRF-TOKEN")})}
      /*{
        headers: new HttpHeaders({"${_csrf.headerName}": "${_csrf.token}"})
      }*/);
  }
}
