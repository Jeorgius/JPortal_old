import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {HttpClientModule, HttpClientXsrfModule} from "@angular/common/http";
import {MusicCreatorComponent} from "./creators/music-creator/music-creator.component";
import {NewsCreatorComponent} from "./creators/news-creator/news-creator.component";
import {PhotoCreatorComponent} from "./creators/photo-creator/photo-creator.component";
import {ProductCreatorComponent} from "./creators/product-creator/product-creator.component";
import {AddButtonComponent} from "./creator_blocks/add-button/add-button.component";
import {EditBarComponent} from "./creator_blocks/edit_bar/edit-bar.component";
import {FormsModule} from "@angular/forms";
import { DragNDropDirective } from './directives/drag-ndrop.directive';
import {CookieService} from "ngx-cookie-service";
import { TextOnlyComponent } from './creator_blocks/block-factory/text-only/text-only.component';
import { MediaOnlyComponent } from './creator_blocks/block-factory/media-only/media-only.component';
import { MediaLeftComponent } from './creator_blocks/block-factory/media-left/media-left.component';
import { MediaRightComponent } from './creator_blocks/block-factory/media-right/media-right.component';
import { SvgIconComponent } from './creator_blocks/block-adder/spriter/svg-icon/svg-icon.component';
import {BlockFactoryComponent} from "./creator_blocks/block-factory/block-factory.component";
import { BlockAdderComponent } from './creator_blocks/block-adder/block-adder.component';

@NgModule({
  declarations: [
    AddButtonComponent,
    EditBarComponent,
    MusicCreatorComponent,
    NewsCreatorComponent,
    PhotoCreatorComponent,
    ProductCreatorComponent,

    DragNDropDirective,

    TextOnlyComponent,
    MediaOnlyComponent,
    MediaLeftComponent,
    MediaRightComponent,
    BlockFactoryComponent,
    SvgIconComponent,
    BlockAdderComponent
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
    DragNDropDirective,

    TextOnlyComponent,
    MediaOnlyComponent,
    MediaLeftComponent,
    MediaRightComponent
  ],
  providers: [
    CookieService
  ]
})
export class AdminModule { }
