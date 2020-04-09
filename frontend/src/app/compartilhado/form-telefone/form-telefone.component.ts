import { Component, Input, Output, EventEmitter } from '@angular/core';
import {Telefone} from '../../interfaces/telefone';

@Component({
  selector: 'app-form-telefone',
  templateUrl: './form-telefone.component.html',
  styleUrls: ['./form-telefone.component.css']
})
export class FormTelefoneComponent {

  @Input() telefone: Telefone = <Telefone>{};
  @Output() outPutTelefone: EventEmitter<Telefone> = new EventEmitter<Telefone>();

  onSubmit() {
    this.outPutTelefone.emit(this.telefone);
  }
}
