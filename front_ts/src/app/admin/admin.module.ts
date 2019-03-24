import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {HttpClientModule, HttpClientXsrfModule} from "@angular/common/http";
import {MusicCreatorComponent} from "./music-creator/music-creator.component";
import {NewsCreatorComponent} from "./news-creator/news-creator.component";
import {PhotoCreatorComponent} from "./photo-creator/photo-creator.component";
import {ProductCreatorComponent} from "./product-creator/product-creator.component";
import {AddButtonComponent} from "./add-button/add-button.component";
import {EditBarComponent} from "./edit_bar/edit-bar.component";
import {FormsModule} from "@angular/forms";
import { DragNDropDirective } from './news-creator/directives/drag-ndrop.directive';
import {CookieService} from "ngx-cookie-service";

@NgModule({
  declarations: [
    AddButtonComponent,
    EditBarComponent,
    MusicCreatorComponent,
    NewsCreatorComponent,
    PhotoCreatorComponent,
    ProductCreatorComponent,
    DragNDropDirective
  ],
  imports: [
    CommonModule,
    HttpClientModule,
    HttpClientXsrfModule.withOptions({cookieName:"XSRF-TOKEN",headerName:"X-CSRF-TOKEN"}),
    FormsModule
  ],
  exports: [
    AddButtonComponent,
    EditBarComponent,
    MusicCreatorComponent,
    NewsCreatorComponent,
    PhotoCreatorComponent,
    ProductCreatorComponent,
    DragNDropDirective
  ],
  providers: [
    CookieService
  ]
})
export class AdminModule { }
