import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from "./AppComponent";
import { NewsComponent } from './news/news.component';
import { MusicComponent } from './music/music.component';
import { PhotosComponent } from './photos/photos.component';
import { StoreComponent } from './store/store.component';
import { UsersComponent } from './users/users.component';
import { AboutComponent } from './about/about.component';
import { RegisterComponent } from './register/register.component';
import { HttpClientModule } from '@angular/common/http';
import { UserDetailComponent } from './user-detail/user-detail.component';
import { LoginComponent } from './login/login.component';

import {DisplayService} from "../services/display.service";

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
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    DisplayService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
