import {Component, OnInit, ViewChild} from '@angular/core';
import {PessoaService} from '../../services/pessoa.service';
import {AuthService} from '../login/auth.service';
import {ErrorMsgComponent} from '../../compartilhado/error-msg/error-msg.component';
import {Usuario} from '../../classes/usuario';
import {TelefoneService} from '../../services/telefone.service';
import {Router} from '@angular/router';
import {Pessoa} from '../../interfaces/pessoa';
import {HttpClient} from '@angular/common/http';
import {Telefone} from '../../interfaces/telefone';

@Component({
  selector: 'app-listar-pessoa-telefone',
  templateUrl: './listar-pessoa-telefone.component.html',
  styleUrls: ['./listar-pessoa-telefone.component.css']
})
export class ListarPessoaTelefoneComponent implements OnInit {

  public p: Pessoa[];
  public t: Telefone[];

  public ususario: Usuario = this.authService.obtemDadosDoUsuario();

  @ViewChild(ErrorMsgComponent) errorMsgComponent: ErrorMsgComponent;
  constructor(private pessoaService: PessoaService,
              private telefoneService: TelefoneService,
              private router: Router,
              private http: HttpClient,
              private authService: AuthService) { }

  ngOnInit(): void {
    this.getListaTelefones();
  }

  getListaPessoas() {
    return this.p;
  }

  deletaPessoa(id: number) {
    this.pessoaService.deletaPessoa(id)
      .subscribe(
        () => {this.deletaTelefone(id); },
        () => {this.errorMsgComponent.setError('Falha ao deletar'); });
    this.router.navigateByUrl('/pessoa/listar');
  }

  deletaTelefone(id: number) {
    this.telefoneService.deletaTelefone(id)
      .subscribe( () => this.router.navigateByUrl('/pessoa/listar'),
        () => { this.errorMsgComponent.setError('Falha ao deletar telefone.');
      });
  }

  // existemPessoas(): boolean {
  //   return this.pessoas && this.pessoas.length > 0;
  // }

  getPessoaById(id: number) {
    this.pessoaService.getPessoa(id).subscribe(
      data => {
        if (data[0].res.status === 200) {

          this.p = data[0].res._body.code;
        } else if (data[0].res.status === 500) {
          console.log(data.toString());
        }},
      () => {this.errorMsgComponent.setError('Falha ao buscar pessoa por id'); });
  }

  getTelefoneById(id: number) {
    this.telefoneService.getTelefone(id).subscribe(
        data => {
          if (data[0].res.status === 200) {

            this.t = data[0].res._body.code;
          } else if (data[0].res.status === 500) {
            console.log(data.toString());
          }},
      () => {this.errorMsgComponent.setError('Falha ao buscar o telefone por id'); }
    );
  }

  existemTelefones(): boolean {
    return this.t && this.t.length > 0;
  }

  getListaTelefones() {
    return this.t;
  }
}
