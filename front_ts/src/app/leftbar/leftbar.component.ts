import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-leftbar',
  templateUrl: './leftbar.component.html',
  styleUrls: ['./leftbar.component.scss']
})
export class LeftbarComponent implements OnInit {

  constructor() { }

  ngOnInit() {
    this.loginAnimation();
  }

  loginAnimation() {
    let d = document,
      loginClass = d.getElementsByClassName('login'),
      login = loginClass[0],
      yA = d.getElementById('YourAction'),
      k = 0;

    yA.addEventListener('mouseover', () => {login.setAttribute('style', 'opacity: 1;');});
    yA.addEventListener('mouseout', () => {login.setAttribute('style', 'opacity: 0;');});

    yA.onclick = () => {
      if(k===0) {
        login.setAttribute("style", "opacity :1");
        yA.addEventListener('mouseover', () => {login.setAttribute('style', 'opacity:1;');});
        yA.addEventListener('mouseout', () => {login.setAttribute('style', 'opacity:1;');});
        k=1;
        return k;
      }   else {
        login.setAttribute('style', 'opacity:0');
        yA.addEventListener('mouseover', () => {login.setAttribute('style', 'opacity:1;')});
        yA.addEventListener('mouseout', () => {login.setAttribute('style', 'opacity:0;')});
        k=0;
        return k;

      }
    }

  }
}
