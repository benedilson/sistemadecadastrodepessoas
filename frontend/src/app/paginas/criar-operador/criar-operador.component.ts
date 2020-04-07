import {Component, ViewChild} from '@angular/core';
import {ErrorMsgComponent} from '../../compartilhado/error-msg/error-msg.component';
import {OperadorService} from '../../services/operador.service';
import {Router} from '@angular/router';
import {Operador} from '../../interfaces/operador';

@Component({
  selector: 'app-criar-operador',
  templateUrl: './criar-operador.component.html',
  styleUrls: ['./criar-operador.component.css']
})
export class CriarOperadorComponent {
  @ViewChild(ErrorMsgComponent) errorMsgComponent: ErrorMsgComponent;
  constructor(private operadorService: OperadorService, private router: Router) { }

  addOperador(operador: Operador) {
    this.operadorService.addOperador(operador)
      .subscribe(
        () => {this.router.navigateByUrl('/operador/listar'); },
        () => {this.errorMsgComponent.setError('Falaha ao adicionar operador'); }
      );
  }

}
