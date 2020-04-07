type tipoPessoa = 'FISICA' | 'JURIDICA';

export interface Pessoa {
  idPessoa: number;
  tipoPessoa: tipoPessoa;
  loginOperador: string;
  dataDeCadastroPessoa: string;
  nomeDoPaiPessoa: string;
  nomeDaMaePessoa: string;
  dataDeNascimento: string;
  documentoPessoa: string;
  nomePessoa: string;
}
