import {Component, ViewChild} from '@angular/core';
import {ErrorMsgComponent} from '../../compartilhado/error-msg/error-msg.component';
import {ActivatedRoute, Router} from '@angular/router';
import {TelefoneService} from '../../services/telefone.service';
import {Operador} from '../../interfaces/operador';
import {Telefone} from '../../interfaces/telefone';

@Component({
  selector: 'app-editar-telefone',
  templateUrl: './editar-telefone.component.html',
  styleUrls: ['./editar-telefone.component.css']
})
export class EditarTelefoneComponent {
  public telefone: Telefone;

  @ViewChild(ErrorMsgComponent) errorMsgComponent: ErrorMsgComponent;
  constructor(
    private telefoneService: TelefoneService,
    private activatedRoute: ActivatedRoute,
    private router: Router) { }

  getTelefone(id: number) {
    this.telefoneService.getTelefone(id)
      .subscribe((telefone: Telefone) => {
        this.telefone = telefone;
      }, () => {this.errorMsgComponent.setError('Falha ao buscar telefone.'); });
  }

  atualizaTelefone(telefone: Telefone) {
    this.telefoneService.atualizaTelefone(telefone)
      .subscribe(
        () => {this.router.navigateByUrl('/telefone/listar'); },
        () => {this.errorMsgComponent.setError('Falha ao atualizar telefone.'); });
  }

}
