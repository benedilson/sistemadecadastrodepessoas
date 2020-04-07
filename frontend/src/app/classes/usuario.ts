type perfil = 'GERENTE' | 'ANALISTA' | 'ADMINISTRADOR';

export class Usuario {
  idUsuario: number;
  nomeUsuario: string;
  loginUsuario: string;
  senhaUsuario: string;
  perfilUsuario: perfil;
  dataDeCadastroUsuario: string;
}
