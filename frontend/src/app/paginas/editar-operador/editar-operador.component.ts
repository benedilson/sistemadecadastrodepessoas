import {Component, ViewChild} from '@angular/core';
import {ErrorMsgComponent} from '../../compartilhado/error-msg/error-msg.component';
import {ActivatedRoute, Router} from '@angular/router';
import {Operador} from '../../interfaces/operador';
import {OperadorService} from '../../services/operador.service';

@Component({
  selector: 'app-editar-operador',
  templateUrl: './editar-operador.component.html',
  styleUrls: ['./editar-operador.component.css']
})
export class EditarOperadorComponent {
  public operador: Operador;

  @ViewChild(ErrorMsgComponent) errorMsgComponent: ErrorMsgComponent;
  constructor(
    private operadorService: OperadorService,
    private activatedRoute: ActivatedRoute,
    private router: Router) {
    this.getOperador(this.activatedRoute.snapshot.params.id);
  }

  getOperador(id: number) {
    this.operadorService.getOperador(id)
      .subscribe((operador: Operador) => {
        this.operador = operador;
      }, () => {this.errorMsgComponent.setError('Falha ao buscar operador.'); });
  }

  atualizaOperador(operador: Operador) {
    this.operadorService.atualizaOperador(operador)
      .subscribe(
        () => {this.router.navigateByUrl('/operador/listar'); },
        () => {this.errorMsgComponent.setError('Falha ao atualizar operador.'); });
  }

}
