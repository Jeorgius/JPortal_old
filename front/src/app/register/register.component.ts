import { Component, OnInit } from '@angular/core';
import { UserReg } from '../user-detail/userReg';
import {DisplayService} from "../../services/display.service";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  userReg = new UserReg ('','','','','','', false);

  constructor(private register: DisplayService) { }

  ngOnInit() {
  }

  submitReg(){
    this.register.regUser(this.userReg)
    .subscribe(data => console.log("YES", data),
               error => console.log(error))
  }

}
