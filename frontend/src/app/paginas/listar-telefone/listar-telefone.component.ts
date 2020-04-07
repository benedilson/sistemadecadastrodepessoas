import {Component, OnInit, ViewChild} from '@angular/core';
import {Telefone} from '../../interfaces/telefone';
import {TelefoneService} from '../../services/telefone.service';
import {ErrorMsgComponent} from '../../compartilhado/error-msg/error-msg.component';

@Component({
  selector: 'app-listar-telefone',
  templateUrl: './listar-telefone.component.html',
  styleUrls: ['./listar-telefone.component.css']
})
export class ListarTelefoneComponent implements OnInit {
  public telefones: Telefone[];
  @ViewChild(ErrorMsgComponent) errorMsgComponent: ErrorMsgComponent;
  constructor(private telefoneService: TelefoneService) { }

  ngOnInit() {
    this.getListaTelefones();
  }

  getListaTelefones() {
    this.telefoneService.getListaTelefones();
  }

  deletaTelefone(id: number) {
    this.telefoneService.deletaTelefone(id)
      .subscribe(() => {
        this.getListaTelefones();
      }, () => {
        this.errorMsgComponent.setError('Falha ao deletar telefone.');
      });
  }

  existemOperadores(): boolean {
    return this.telefones && this.telefones.length > 0;
  }
}
