import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'replace',
})
export class ReplacePipe implements PipeTransform {
  transform(
    value: string,
    item: string,
    to: string,
    all: boolean = false
  ): string {
    return all ? value.replaceAll(item, to) : value.replace(item, to);
  }
}
