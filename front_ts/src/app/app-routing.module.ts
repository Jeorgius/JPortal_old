import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AboutComponent } from './content/about/about.component';
import { MusicComponent } from './content/music/music.component';
import { NewsComponent } from './content/news/news.component';
import { PhotosComponent } from './content/photos/photos.component';
import { RegisterComponent } from './content/users/register/register.component';
import { StoreComponent } from './content/store/store.component';
import { UsersComponent } from './content/users/users.component';
import { UserDetailComponent } from './content/users/user-detail/user-detail.component';
import {NewsCreatorComponent} from "./admin/news-creator/news-creator.component";
import {ProductCreatorComponent} from "./admin/product-creator/product-creator.component";
import {PhotoCreatorComponent} from "./admin/photo-creator/photo-creator.component";
import {MusicCreatorComponent} from "./admin/music-creator/music-creator.component";
import {Model3dComponent} from "./content/model3d/model3d.component";


const routes: Routes = [
  {path: '', redirectTo: '/news', pathMatch: 'full' },
  {path: 'about', component: AboutComponent},
  {path: 'music', component: MusicComponent},
  {path: 'news', component: NewsComponent},
  {path: 'photos', component: PhotosComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'store', component: StoreComponent},
  {path: 'users', component: UsersComponent},
  {path: 'users/:nickname', component: UserDetailComponent},
  {path: '3d', component: Model3dComponent},

  {path: 'admin/create/news', component: NewsCreatorComponent},
  {path: 'admin/create/product', component: ProductCreatorComponent},
  {path: 'admin/create/photo', component: PhotoCreatorComponent},
  {path: 'admin/create/music', component: MusicCreatorComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

export const routeComponents = [
  AboutComponent,
  MusicComponent,
  NewsComponent,
  PhotosComponent,
  RegisterComponent,
  StoreComponent,
  UsersComponent,
  UserDetailComponent
];
