import { Component } from '@angular/core';
import { categoryType } from '../services/filter.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
})
export class HomeComponent {
  categories: categoryType[] = ['all', 'from_artist', 'ai_arts'];
  category: categoryType = "all";

  setCategory(value: categoryType)
  { 
    this.category = value;
  }
}
