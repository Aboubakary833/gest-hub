import { Component, Input } from '@angular/core';
import { cva } from 'class-variance-authority';

const avatarVariant = cva(
  "rounded-full",
  {
    variants: {
      size: {
        sm: "w-4 h-4 sm:w-6 sm:h-6",
        base: "w-6 h-6 sm:w-8 sm:h-8",
        lg: "w-8 h-8 sm:w-10 sm:h-10"
      }
    },
    defaultVariants: {
      size: "base"
    }
  }
)

type Size = 'sm' | 'base' | 'lg';

@Component({
  selector: 'app-avatar',
  templateUrl: './avatar.component.html',
  styleUrls: ['./avatar.component.css']
})
export class AvatarComponent {
  @Input() alt: string = "user";
  @Input() url: string = "assets/user.png";
  @Input() size?: Size = "base";
  avatarVariant = avatarVariant;
}
