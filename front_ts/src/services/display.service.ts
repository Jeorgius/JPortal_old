import { Injectable } from '@angular/core';
import { HttpClient} from "@angular/common/http";

import  { newsList, musicList, photoList,
          UserReg, storeList, userList } from "../interfaces/displayContent";

@Injectable({
  providedIn: 'root'
})
export class DisplayService {
  private dataSource = '../assets/data/';
  private JavaServer = '';

  constructor(private HTML: HttpClient) { }
  getMusic() {
    return this.HTML.get<musicList[]>(this.dataSource+'music.json');
  }
  getUsers(){
    return this.HTML.get<userList[]>(this.dataSource+'users.json');
  }
  getItems() {
    return this.HTML.get<storeList[]>(this.dataSource+'store.json');
  }
  regUser(user : UserReg){
    return this.HTML.post<any>(this.JavaServer, user);
  }
  getNews (){
    return this.HTML.get<newsList[]>(this.dataSource+'news.json');
  }
  getPhotos(){
    return this.HTML.get<photoList[]>(this.dataSource+'photos.json');
  }
}
