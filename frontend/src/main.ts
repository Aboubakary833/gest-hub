import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';

import { AppModule } from './app/app.module';
import "node_modules/preline/dist/preline.js"


platformBrowserDynamic().bootstrapModule(AppModule)
  .catch(err => console.error(err));
