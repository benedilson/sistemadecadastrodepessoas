import {EventEmitter, Injectable} from '@angular/core';
import {Router} from '@angular/router';
import {Usuario} from '../../classes/usuario';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private usuarioGlobal: Usuario;
  private ususrioAutenticado = false;

  mostrarEmitter = new EventEmitter<boolean>();

  constructor(private router: Router) { }

  fazerLogin(usuario: Usuario) {
      if (usuario.nomeUsuario === 'a' && usuario.senhaUsuario === 'a') {
        usuario.perfilUsuario = 'ADMINISTRADOR';
        this.ususrioAutenticado = true;
        this.usuarioGlobal = usuario;
        this.mostrarEmitter.emit(true);
        this.router.navigate(['/operador/listar']);
      } else if (usuario.nomeUsuario === 'g' && usuario.senhaUsuario === 'g') {
        usuario.perfilUsuario = 'GERENTE';
        this.ususrioAutenticado = true;
        this.usuarioGlobal = usuario;
        this.mostrarEmitter.emit(true);
        this.router.navigate(['/pessoa/listar']);
      } else if (usuario.nomeUsuario === 'analista' && usuario.senhaUsuario === 'analista') {
        usuario.perfilUsuario = 'ANALISTA';
        this.ususrioAutenticado = true;
        this.usuarioGlobal = usuario;
        this.mostrarEmitter.emit(true);
        this.router.navigate(['/pessoa/listar']);
      } else {
        this.mostrarEmitter.emit(false);
      }
  }

  usuarioEstaAutenticado() {
    return this.ususrioAutenticado;
  }

  obtemDadosDoUsuario() {
    return this.usuarioGlobal;
  }
}
