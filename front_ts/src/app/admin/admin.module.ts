import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {HttpClientModule} from "@angular/common/http";
import {MusicCreatorComponent} from "./music-creator/music-creator.component";
import {NewsCreatorComponent} from "./news-creator/news-creator.component";
import {PhotoCreatorComponent} from "./photo-creator/photo-creator.component";
import {ProductCreatorComponent} from "./product-creator/product-creator.component";
import {AddButtonComponent} from "./add-button/add-button.component";
import {EditBarComponent} from "./edit_bar/edit-bar.component";
import {FormsModule} from "@angular/forms";

@NgModule({
  declarations: [
    AddButtonComponent,
    EditBarComponent,
    MusicCreatorComponent,
    NewsCreatorComponent,
    PhotoCreatorComponent,
    ProductCreatorComponent
  ],
  imports: [
    CommonModule,
    HttpClientModule,
    FormsModule
  ],
  exports: [
    AddButtonComponent,
    EditBarComponent,
    MusicCreatorComponent,
    NewsCreatorComponent,
    PhotoCreatorComponent,
    ProductCreatorComponent
  ]
})
export class AdminModule { }
