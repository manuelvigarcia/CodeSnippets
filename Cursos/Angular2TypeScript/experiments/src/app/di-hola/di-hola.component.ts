import { Component } from '@angular/core';

@Component({
  selector: 'app-di-hola',
  templateUrl: './di-hola.component.html'
})
export class DiHolaComponent {
  texto:string = "¡Hola!"
  sayHello(event:any) :void {
    alert(event.target.value);
  }

}
