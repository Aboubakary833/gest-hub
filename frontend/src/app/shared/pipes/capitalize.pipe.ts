import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'capitalize',
})
export class CapitalizePipe implements PipeTransform {
  transform(value: string): string {
    return value
      .split(' ')
      .map((chunk) => `${chunk.charAt(0).toUpperCase()}${chunk.slice(1)}`)
      .join(' ');
  }
}
