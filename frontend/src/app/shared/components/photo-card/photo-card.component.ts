import { Component, Input } from '@angular/core';

@Component({
  selector: 'photo-card',
  templateUrl: './photo-card.component.html'
})
export class PhotoCardComponent {
  @Input() url: string = "";
}
