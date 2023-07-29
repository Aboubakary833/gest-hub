import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-link',
  templateUrl: './link.component.html',
})
export class LinkComponent {
  @Input() path?: string;
  @Input() customClass: string = "";
  constructor(public router: Router) {}
}
