import { Injectable } from '@angular/core';
import {Router} from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class CreatorDeterminatorService {

  private adminRoute:string = "/admin";
  constructor(
    private CurrentLink :Router
  ) { }

  goToCreator(){
    this.CurrentLink.navigateByUrl(this.creatorLink());
  }

  private creatorLink(){
    let section = this.CurrentLink.url;
    if(section==="/photos") return this.adminRoute+"/create/photo";
    if(section==="/store") return this.adminRoute+"/create/product";
    if(section==="/news") return this.adminRoute+"/create/news";
    if(section==="/music") return this.adminRoute+"/create/music";
    return "/news";
  }
}
