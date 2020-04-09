type tipoTel = 'CELULAR' | 'FIXO' | 'COMERCIAL';

export interface Telefone {
  idTelefone: number;
  dddTelefone: string;
  numeroTelefone: string;
  tipoTelefone: tipoTel;
  dataDeCadastroTelefone: string;
  loginOperador: string;
  idPessoa: number;
}
