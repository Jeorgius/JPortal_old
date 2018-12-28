import { Injectable } from '@angular/core';
import { HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private dataSource = "https://localhost:8007/login/"

  constructor(private HTML: HttpClient) { }
  loginFB(){
    return this.HTML.get<any>(this.dataSource+"fb");
  }
}
