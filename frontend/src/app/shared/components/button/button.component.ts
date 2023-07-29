import { Component, Input } from '@angular/core';
import { cva } from 'class-variance-authority';

const buttonVariants = cva(
  'w-fit inline-flex items-center justify-center rounded-xl text-sm font-medium ring-offset-white transition-colors focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-offset-2 disabled:pointer-events-none disabled:opacity-50',
  {
    variants: {
      variant: {
        primary:
          'bg-primary text-slate-50 hover:bg-primary/90 focus-visible:ring-primary-400',
        success:
          'bg-success text-slate-50 hover:bg-success-400 active:bg-success-600 focus-visible:ring-success-400',
        warning:
          'bg-warning text-slate-900 hover:bg-warning-400 active:bg-warning-600 focus-visible:ring-warning-400',
        danger:
          'bg-danger text-slate-50 hover:bg-danger-400 active:bg-danger-600 focus-visible:ring-danger-400',
        ghost: 'bg-gray-50 hover:bg-gray-100 hover:text-gray-700',
      },
      size: {
        base: 'h-10 px-4 py-2',
        sm: 'h-9 px-3',
        lg: 'h-11 rounded-2xl px-8',
        icon: 'h-10 w-10',
      },
    },
    defaultVariants: {
      variant: 'primary',
      size: 'base',
    },
  }
);

type Variant = 'primary' | 'success' | 'warning' | 'danger' | 'ghost';
type Size = 'sm' | 'base' | 'lg' | 'icon';

@Component({
  selector: 'app-button',
  templateUrl: './button.component.html',
})
export class ButtonComponent {
  @Input() variant?: Variant = "primary";
  @Input() type?: 'button' | 'submit' = "button";
  @Input() size?: Size = "base";
  @Input() customClass: string = '';
  buttonVariants = buttonVariants;
}
