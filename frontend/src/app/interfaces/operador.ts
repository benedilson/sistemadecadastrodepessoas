type perfil = 'GERENTE' | 'ANALISTA';

export interface Operador {
  idOperador: number;
  nomeOperador: string;
  loginOperador: string;
  senhaOperador: string;
  perfilOperador: perfil;
  dataDeCadastroOperador: string;

  json(): Operador;
}
