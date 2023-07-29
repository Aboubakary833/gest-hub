import { Injectable } from '@angular/core';

export type categoryType = "all" | "from_artist" | "ai_arts";

@Injectable({
  providedIn: 'root'
})
export class FilterService {

  constructor() { }
  
  requestFor(value: categoryType)
  {
    console.log(value);
    
  }
}
