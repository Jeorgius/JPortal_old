import { Component, OnInit } from '@angular/core';
import {DisplayService} from "../../services/display.service";


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  private JavaSocial = 'http://localhost:8777/login/fb';

  constructor(private LoginUser : DisplayService) { }
  ngOnInit() {}

  submitLogin(){
      console.log("yes");
  }

  submitSocialLogin(){
    console.log("yes");
    this.LoginUser.loginUser().subscribe(data => console.log(data));
  }


}
