import { Component, OnInit } from '@angular/core';
import {LoginService} from "../../services/login.service";


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  private JavaRest = 'https://localhost:8007/login/';
  public isLoggedIn: boolean;

  constructor(private LoginUser : LoginService) { }
  ngOnInit() {}

  isLogged(){
    return this.LoginUser.checkIfLogged().subscribe(data => this.isLoggedIn = data.isLogged);
  }
  submitLogin(){
      console.log("yes");
  }

  submitSocialLogin(){
    console.log("yes");
    this.LoginUser.loginFB().subscribe(data => console.log(data));
  }


}
