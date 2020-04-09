import { Component, Input, Output, EventEmitter } from '@angular/core';
import {Operador} from '../../interfaces/operador';

@Component({
  selector: 'app-form-operador',
  templateUrl: './form-operador.component.html',
  styleUrls: ['./form-operador.component.css']
})
export class FormOperadorComponent {

  @Input() operador: Operador = <Operador>{};
  @Output() outPutOperador: EventEmitter<Operador> = new EventEmitter<Operador>();

  onSubmit() {
    this.outPutOperador.emit(this.operador);
  }

}


