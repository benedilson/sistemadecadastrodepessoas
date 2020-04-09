import {Component, ViewChild} from '@angular/core';
import {ErrorMsgComponent} from '../../compartilhado/error-msg/error-msg.component';
import {ActivatedRoute, Router} from '@angular/router';
import {PessoaService} from '../../services/pessoa.service';
import {Pessoa} from '../../interfaces/pessoa';

@Component({
  selector: 'app-editar-pessoa',
  templateUrl: './editar-pessoa.component.html',
  styleUrls: ['./editar-pessoa.component.css']
})
export class EditarPessoaComponent {
  public pessoa: Pessoa;
  @ViewChild(ErrorMsgComponent) errorMsgComponent: ErrorMsgComponent;

  constructor(
    private pessoaService: PessoaService,
    private activatedRoute: ActivatedRoute,
    private router: Router) {
    this.getPessoa(this.activatedRoute.snapshot.params.id);
  }

  getPessoa(id: number) {
    this.pessoaService.getPessoa(id)
      .subscribe((pessoa: Pessoa) => {
        this.pessoa = pessoa;
      }, () => {this.errorMsgComponent.setError('Falha ao buscar pessoa.'); });
  }

  atualizaPessoa(pessoa: Pessoa) {
    this.pessoaService.atualizaPessoa(pessoa)
      .subscribe(
        () => {this.router.navigateByUrl('/pessoa/listar'); },
        () => {this.errorMsgComponent.setError('Falha ao atualizar pessoa.'); });
  }


}


