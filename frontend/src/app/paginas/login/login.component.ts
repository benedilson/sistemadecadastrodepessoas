import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Usuario} from '../../interfaces/usuario';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  @Input() usuario: Usuario = <Usuario>{};
  @Output() outPutUsusario: EventEmitter<Usuario> = new EventEmitter<Usuario>();

  onSubmit() {
      this.outPutUsusario.emit(this.usuario);
  }

}
