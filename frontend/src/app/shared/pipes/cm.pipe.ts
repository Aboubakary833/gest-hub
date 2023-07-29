import { Pipe, PipeTransform } from '@angular/core';
import { ClassValue } from 'clsx';
import cm from '../utils/cm';

@Pipe({
  name: 'cm'
})
export class CmPipe implements PipeTransform {

  transform(variants: string, customClass: string = ""): string {
    return cm(variants, customClass);
  }

}
