import { Component, OnInit } from '@angular/core';
import {LoginService} from "../services/login.service";


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  //private JavaRest = 'https://localhost:8007/login/';
  public isLoggedIn: boolean;
  public userName: string;

  constructor(private LoginUser : LoginService) {}

  ngOnInit() {
    this.isLogged();
  }

  isLogged(){
    return this.LoginUser
      .checkIfLogged()
      .subscribe(data => {
        if(data.name){
          this.isLoggedIn = true;
          this.userName = data.name+ " " + data.surname;
        } else {
          this.isLoggedIn = false;
          this.userName = "";
        }
      });
  }

  logout(){
    this.LoginUser.logout().subscribe();
    this.isLoggedIn = false;
  }

  submitLogin(){
      console.log("yes");
  }


}
