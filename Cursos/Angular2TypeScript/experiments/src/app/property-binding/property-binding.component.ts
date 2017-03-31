import { Component } from '@angular/core';

@Component({
  selector: 'app-property-binding',
  templateUrl: './property-binding.component.html'
})
export class PropertyBindingComponent {
  title:string ="Property Binding"
  userName:string = "David";
  changed:boolean = false;
}
