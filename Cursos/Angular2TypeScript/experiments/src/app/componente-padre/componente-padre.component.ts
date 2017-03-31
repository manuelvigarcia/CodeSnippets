import { Component } from '@angular/core';

@Component({
  selector: 'app-componente-padre',
  templateUrl: './componente-padre.component.html',
  styleUrls: ['./componente-padre.component.css']
})
export class ComponentePadreComponent {
  frase:string = "Valor Desconocido";

  listenerPadre(event) : void {
    this.frase = event;
  }
}
