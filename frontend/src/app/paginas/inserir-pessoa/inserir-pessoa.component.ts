import { Component, ViewChild } from '@angular/core';
import {ErrorMsgComponent} from '../../compartilhado/error-msg/error-msg.component';
import {Router} from '@angular/router';
import {PessoaService} from '../../services/pessoa.service';
import {Pessoa} from '../../interfaces/pessoa';

@Component({
  selector: 'app-inserir-pessoa',
  templateUrl: './inserir-pessoa.component.html',
  styleUrls: ['./inserir-pessoa.component.css']
})
export class InserirPessoaComponent  {

  @ViewChild(ErrorMsgComponent) errorMsgComponent: ErrorMsgComponent;

  constructor(private pessoaService: PessoaService, private router: Router) {
  }

  addPessoa(pessoa: Pessoa) {
    this.pessoaService.addPessoa(pessoa)
      .subscribe(
        () => {this.router.navigateByUrl('/pessoa/listar'); },
        () => {this.errorMsgComponent.setError('Falaha ao adicionar pessoa'); }
      );
  }

}


