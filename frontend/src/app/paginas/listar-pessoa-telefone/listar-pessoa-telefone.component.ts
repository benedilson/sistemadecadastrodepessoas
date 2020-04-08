import {Component, OnInit, ViewChild} from '@angular/core';
import {PessoaService} from '../../services/pessoa.service';
import {AuthService} from '../login/auth.service';
import {ErrorMsgComponent} from '../../compartilhado/error-msg/error-msg.component';

@Component({
  selector: 'app-listar-pessoa-telefone',
  templateUrl: './listar-pessoa-telefone.component.html',
  styleUrls: ['./listar-pessoa-telefone.component.css']
})
export class ListarPessoaTelefoneComponent implements OnInit {

  @ViewChild(ErrorMsgComponent) errorMsgComponent: ErrorMsgComponent;
  constructor(private pessoaService: PessoaService, private authService: AuthService) { }

  ngOnInit(): void {
  }

  getListaPessoas() {
    this.pessoaService.getListaPessoas();
  }

  deletaPessoa(id: number) {
    this.pessoaService.deletaPessoa(id)
      .subscribe(
        () => {this.getListaPessoas(); },
        () => {this.errorMsgComponent.setError('Falha ao deletar pessoa'); });
  }

  // existemPessoas(): boolean {
  //   return this.pessoas && this.pessoas.length > 0;
  // }


}
