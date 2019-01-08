import { Injectable } from '@angular/core';
import { HttpClient} from "@angular/common/http";
import {LoggedIn} from "../interfaces/Authentication";

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private dataSource = "https://localhost:8007/login/";

  constructor(private HTML: HttpClient) { }
  loginFB(){
    return this.HTML.get<any>(this.dataSource+"fb");
  }
  checkIfLogged(){
    return this.HTML.get<LoggedIn>(this.dataSource+"islogged");
  }

  logout(){
    return this.HTML.post(this.dataSource+"logout",{});
  }
}
