import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Operador} from '../interfaces/operador';
import {environment} from '../../environments/environment';
import {Pessoa} from '../interfaces/pessoa';

@Injectable({
  providedIn: 'root'
})
export class PessoaService {

  constructor(private http: HttpClient) { }

  getListaPessoas(): Observable<Pessoa[]> {
    const url = `${environment.sistemaDeCadastroApiUrl}/pessoa`;
    return this.http.get<Pessoa[]>(url);
  }

  getPessoa(id: number): Observable<Pessoa> {
    const url = `${environment.sistemaDeCadastroApiUrl}/pessoa/${id}`;
    return this.http.get<Pessoa>(url);
  }

  addPessoa(pessoa: Pessoa): Observable<Pessoa> {
    const url = `${environment.sistemaDeCadastroApiUrl}/pessoa/`;
    return this.http.post<Pessoa>(url, pessoa);
  }

  atualizaPessoa(pessoa: Pessoa): Observable<Pessoa> {
    const url = `${environment.sistemaDeCadastroApiUrl}/pessoa/${pessoa.idPessoa}`;
    return this.http.put<Pessoa>(url, pessoa);
  }

  deletaPessoa(id: number): Observable<Pessoa> {
    const url = `${environment.sistemaDeCadastroApiUrl}/pessoa/${id}`;
    return this.http.delete<Pessoa>(url);
  }

}
