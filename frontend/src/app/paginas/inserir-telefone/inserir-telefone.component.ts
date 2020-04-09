import {Component, ViewChild} from '@angular/core';
import {ErrorMsgComponent} from '../../compartilhado/error-msg/error-msg.component';
import {TelefoneService} from '../../services/telefone.service';
import {Router} from '@angular/router';
import {Telefone} from '../../interfaces/telefone';

@Component({
  selector: 'app-inserir-telefone',
  templateUrl: './inserir-telefone.component.html',
  styleUrls: ['./inserir-telefone.component.css']
})
export class InserirTelefoneComponent {
  @ViewChild(ErrorMsgComponent) errorMsgComponent: ErrorMsgComponent;
  constructor(private telefoneService: TelefoneService, private router: Router) { }

  addTelefone(telefone: Telefone) {
    this.telefoneService.addTelefone(telefone)
      .subscribe(
        () => {this.router.navigateByUrl('/telefone/listar'); },
        () => {this.errorMsgComponent.setError('Falaha ao adicionar telefone'); }
      );
  }
}
