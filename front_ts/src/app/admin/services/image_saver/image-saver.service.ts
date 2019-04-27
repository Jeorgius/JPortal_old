import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {iImageSave} from "../interfaces/iImageSave";
import {CookieXSRFStrategy} from "@angular/http";
import {CookieService} from "ngx-cookie-service";

@Injectable({
  providedIn: 'root'
})
export class ImageSaverService {

  private MediaServer = "https://localhost:8007/admin/save_image";
  //private MediaServer = "http://localhost:8002";
  constructor(
    private Http :HttpClient,
    private cookies :CookieService) { }

  saveImage(newFile :File) {
    let formSend = new FormData();
    formSend.append("hero", newFile, newFile.name);

    return this.Http.post<iImageSave>(
      this.MediaServer,
      formSend
      );
  }

  // displayLastImage(){
  // }
}
