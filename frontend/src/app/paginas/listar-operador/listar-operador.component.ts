import {Component, OnInit, ViewChild} from '@angular/core';
import {Operador} from '../../interfaces/operador';
import {OperadorService} from '../../services/operador.service';
import {ErrorMsgComponent} from '../../compartilhado/error-msg/error-msg.component';
import {Usuario} from '../../classes/usuario';
import {PessoaService} from '../../services/pessoa.service';
import {AuthService} from '../login/auth.service';

@Component({
  selector: 'app-listar-operador',
  templateUrl: './listar-operador.component.html',
  styleUrls: ['./listar-operador.component.css']
})
export class ListarOperadorComponent implements OnInit {
  public ususario: Usuario = this.authService.obtemDadosDoUsuario();

  public operadores: Operador[];
  @ViewChild(ErrorMsgComponent) errorMsgComponent: ErrorMsgComponent;

  constructor(private operadorService: OperadorService, private authService: AuthService) {
  }

  ngOnInit() {
    this.getListaOperadores();
  }

  getListaOperadores() {
    this.operadorService.getListaOperadores();
  }

  deletaOperador(id: number) {
    this.operadorService.deletaOperador(id)
      .subscribe(() => {
        this.getListaOperadores();
      }, () => {
        this.errorMsgComponent.setError('Falha ao deletar operador.');
      });
  }

  existemOperadores(): boolean {
    return this.operadores && this.operadores.length > 0;
  }
}
