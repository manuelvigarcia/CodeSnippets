import { Component } from '@angular/core';
import { HijoComponent } from '../hijo/hijo.component';

@Component({
  selector: 'app-padre',
  templateUrl: './padre.component.html'
})
export class PadreComponent {
  userName:string = "Me llamo Papá --dice el código del padre";
  periquito:string = "Soy un periquito"
}
