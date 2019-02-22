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
import { EditBarComponent } from './admin/edit_bar/edit-bar.component';
import { NewsCreatorComponent } from './admin/news-creator/news-creator.component';
import { PhotoCreatorComponent } from './admin/photo-creator/photo-creator.component';
import { ProductCreatorComponent } from './admin/product-creator/product-creator.component';
import { MusicCreatorComponent } from './admin/music-creator/music-creator.component';
import { AddButtonComponent } from './admin/add-button/add-button.component';
import {FileDropModule} from "ngx-file-drop";

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
    EditBarComponent,
    NewsCreatorComponent,
    PhotoCreatorComponent,
    ProductCreatorComponent,
    MusicCreatorComponent,
    AddButtonComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    LoginModule,
    FileDropModule
  ],
  providers: [
    DisplayService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
