import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {Operador} from '../interfaces/operador';
import {environment} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {Telefone} from '../interfaces/telefone';

@Injectable({
  providedIn: 'root'
})
export class TelefoneService {

  constructor(private http: HttpClient) { }

  getListaTelefones(): Observable<Telefone[]> {
    const url = `${environment.sistemaDeCadastroApiUrl}/telefone`;
    return this.http.get<Telefone[]>(url);
  }

  getTelefone(id: number): Observable<Telefone> {
    const url = `${environment.sistemaDeCadastroApiUrl}/telefone/${id}`;
    return this.http.get<Telefone>(url);
  }

  addTelefone(telefone: Telefone): Observable<Telefone> {
    const url = `${environment.sistemaDeCadastroApiUrl}/telefone/`;
    return this.http.post<Telefone>(url, telefone);
  }

  atualizaTelefone(telefone: Telefone): Observable<Telefone> {
    const url = `${environment.sistemaDeCadastroApiUrl}/telefone/${telefone.idTelefone}`;
    return this.http.put<Telefone>(url, telefone);
  }

  deletaTelefone(id: number): Observable<Telefone> {
    const url = `${environment.sistemaDeCadastroApiUrl}/telefone/${id}`;
    return this.http.delete<Telefone>(url);
  }
}
