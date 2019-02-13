import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AboutComponent } from './content/about/about.component';
import { MusicComponent } from './content/music/music.component';
import { NewsComponent } from './content/news/news.component';
import { PhotosComponent } from './content/photos/photos.component';
import { RegisterComponent } from './content/register/register.component';
import { StoreComponent } from './content/store/store.component';
import { UsersComponent } from './content/users/users.component';
import { UserDetailComponent } from './content/user-detail/user-detail.component';


const routes: Routes = [
  {path: '', redirectTo: '/news', pathMatch: 'full' },
  {path: 'about', component: AboutComponent},
  {path: 'music', component: MusicComponent},
  {path: 'news', component: NewsComponent},
  {path: 'photo', component: PhotosComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'store', component: StoreComponent},
  {path: 'users', component: UsersComponent},
  {path: 'users/:nickname', component: UserDetailComponent}
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
