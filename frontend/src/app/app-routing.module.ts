import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './features/home/component/home.component';
import { PhotoComponent } from './features/photo/components/photo/photo.component';

const routes: Routes = [
  {
    path: "",
    component: HomeComponent
  },
  {
    path: "photo",
    component: PhotoComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
