import {Component, EventEmitter, Input, Output} from '@angular/core';
import {Pessoa} from '../../interfaces/pessoa';

@Component({
  selector: 'app-form-pessoa',
  templateUrl: './form-pessoa.component.html',
  styleUrls: ['./form-pessoa.component.css']
})
export class FormPessoaComponent {

  @Input() pessoa: Pessoa = <Pessoa>{};
  @Output() outPutPessoa: EventEmitter<Pessoa> = new EventEmitter<Pessoa>();

  onSubmit() {
    this.outPutPessoa.emit(this.pessoa);
  }

}
