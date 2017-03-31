import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-hijo',
  template: 'html del hijo <div>Hola \' {{name}} \'.</div>',
  templateUrl: './hijo.component.html'
})
export class HijoComponent {
  @Input() name:string;
}
