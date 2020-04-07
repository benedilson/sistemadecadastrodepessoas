import {Injectable} from '@angular/core';
import {environment} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Operador} from '../interfaces/operador';

@Injectable({
  providedIn: 'root'
})
export class OperadorService {

  constructor(private http: HttpClient) {
  }

  getListaOperadores(): Observable<Operador[]> {
    const url = `${environment.sistemaDeCadastroApiUrl}/operador`;
    return this.http.get<Operador[]>(url);
  }

  getOperador(id: number): Observable<Operador> {
    const url = `${environment.sistemaDeCadastroApiUrl}/operador/${id}`;
    return this.http.get<Operador>(url);
  }

  addOperador(operador: Operador): Observable<Operador> {
    const url = `${environment.sistemaDeCadastroApiUrl}/operador/`;
    return this.http.post<Operador>(url, operador);
  }

  atualizaOperador(operador: Operador): Observable<Operador> {
    const url = `${environment.sistemaDeCadastroApiUrl}/operador/${operador.idOperador}`;
    return this.http.put<Operador>(url, operador);
  }

  deletaOperador(id: number): Observable<Operador> {
    const url = `${environment.sistemaDeCadastroApiUrl}/operador/${id}`;
    return this.http.delete<Operador>(url);
  }

}

