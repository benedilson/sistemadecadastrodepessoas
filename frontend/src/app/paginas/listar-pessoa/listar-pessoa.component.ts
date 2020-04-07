import {Component, OnInit, ViewChild} from '@angular/core';
import {Pessoa} from '../../interfaces/pessoa';
import {ErrorMsgComponent} from '../../compartilhado/error-msg/error-msg.component';
import {PessoaService} from '../../services/pessoa.service';

@Component({
  selector: 'app-listar-pessoa',
  templateUrl: './listar-pessoa.component.html',
  styleUrls: ['./listar-pessoa.component.css']
})
export class ListarPessoaComponent implements OnInit {
  public pessoas: Pessoa[];
  @ViewChild(ErrorMsgComponent) errorMsgComponent: ErrorMsgComponent;

  constructor(private pessoaService: PessoaService) { }

  ngOnInit() {
    this.getListaPessoas();
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

  existemPessoas(): boolean {
    return this.pessoas && this.pessoas.length > 0;
  }

}
