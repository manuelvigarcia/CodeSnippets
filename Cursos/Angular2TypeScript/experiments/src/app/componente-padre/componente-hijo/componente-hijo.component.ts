import { Component, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-componente-hijo',
  templateUrl: './componente-hijo.component.html',
  styleUrls: ['./componente-hijo.component.css']
})

export class ComponenteHijoComponent {
  @Output() eventoHijo = new EventEmitter();

  diAlgo(mensaje:string) {
    this.eventoHijo.emit(mensaje);
  }
}
