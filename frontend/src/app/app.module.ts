import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AppLayoutComponent } from './shared/components/app-layout/app-layout.component';
import { HeaderComponent } from './shared/components/header/header.component';
import { HomeComponent } from './features/home/component/home.component';
import { AvatarComponent } from './shared/components/avatar/avatar.component';
import { CapitalizePipe } from './shared/pipes/capitalize.pipe';
import { ReplacePipe } from './shared/pipes/replace.pipe';
import { ButtonComponent } from './shared/components/button/button.component';
import { CmPipe } from './shared/pipes/cm.pipe';
import { PhotoCardComponent } from './shared/components/photo-card/photo-card.component';
import {
  LucideAngularModule,
  AlignJustify,
  ChevronDown,
  MessageCircle,
  Bookmark,
  Bell,
  Search,
  Heart,
  MessageSquare,
  Home,
  ImagePlus,
  Users2,
  Rss,
} from 'lucide-angular';
import { LinkComponent } from './shared/components/link/link.component';
import { PhotoComponent } from './features/photo/components/photo/photo.component';

@NgModule({
  declarations: [
    AppLayoutComponent,
    AppComponent,
    HeaderComponent,
    HomeComponent,
    AvatarComponent,
    CapitalizePipe,
    ReplacePipe,
    ButtonComponent,
    CmPipe,
    PhotoCardComponent,
    LinkComponent,
    PhotoComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    LucideAngularModule.pick({
      AlignJustify,
      ChevronDown,
      MessageCircle,
      Bookmark,
      Bell,
      Search,
      Heart,
      MessageSquare,
      Home,
      ImagePlus,
      Users2,
      Rss,
    }),
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
