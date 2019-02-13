import { Component, OnInit } from '@angular/core';
import {DisplayService} from "../../../services/display.service";
import { Router } from '@angular/router';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.scss']
})
export class UsersComponent implements OnInit {

  public userInfo = [];

  constructor(
    private userService: DisplayService,
    private GoToProfile: Router
  ) { }

  openProfile (user){
    this.GoToProfile.navigate(['/users', user.nickname])
  }

  ngOnInit() {
    this.userService.getUsers().subscribe(data => this.userInfo = data);
  }

}
