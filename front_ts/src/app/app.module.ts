import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from "./AppComponent";
import { NewsComponent } from './content/news/news.component';
import { MusicComponent } from './content/music/music.component';
import { PhotosComponent } from './content/photos/photos.component';
import { StoreComponent } from './content/store/store.component';
import { UsersComponent } from './content/users/users.component';
import { AboutComponent } from './content/about/about.component';
import { RegisterComponent } from './content/users/register/register.component';
import { HttpClientModule } from '@angular/common/http';
import { UserDetailComponent } from './content/users/user-detail/user-detail.component';

import {DisplayService} from "../services/display.service";
import {LoginModule} from "./login/login.module";
import { LeftbarComponent } from './leftbar/leftbar.component';
import {AdminModule} from "./admin/admin.module";

import { Model3dComponent } from './content/model3d/model3d.component';
import {NgxMapboxGLModule} from "ngx-mapbox-gl";

@NgModule({
  declarations: [
    AppComponent,
    NewsComponent,
    MusicComponent,
    PhotosComponent,
    StoreComponent,
    UsersComponent,
    AboutComponent,
    RegisterComponent,
    UserDetailComponent,
    LeftbarComponent,

    Model3dComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,

    LoginModule,
    AdminModule,

    NgxMapboxGLModule.withConfig({
      accessToken: 'pk.eyJ1IjoiamVvcmdpdXMiLCJhIjoiY2pzc3Y3Z3JiMTE1YzQzbzRlb3ZmNWJrdSJ9.jFPt7wpDWHkkXqzcSbwQzA'
    })
  ],

  providers: [
    DisplayService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
