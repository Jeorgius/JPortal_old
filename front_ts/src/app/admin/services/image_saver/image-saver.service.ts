import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ImageSaverService {

  private MediaServer = "http://localhost:8007";
  //private MediaServer = "http://localhost:8002";
  constructor(private Http :HttpClient) { }

  saveImage(newFile :File) {
    let formSend = new FormData();
    formSend.append("hero", newFile,"heroTest");

    return this.Http.post(
      this.MediaServer,
      formSend,
      {responseType: "blob"}
    );
  }
}
