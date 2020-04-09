import {EventEmitter, Injectable} from '@angular/core';
import {Router} from '@angular/router';
import {Usuario} from '../../classes/usuario';
import {OperadorService} from '../../services/operador.service';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private usuarioGlobal: Usuario;
  private ususrioAutenticado = false;

  mostrarEmitter = new EventEmitter<boolean>();

  constructor(private router: Router, private operadorService: OperadorService) {
  }

  fazerLogin(usuario: Usuario) {
    this.operadorService.buscaLoginESenha(usuario.loginUsuario, usuario.senhaUsuario)
      .subscribe(data => {
          if (data[0].res.status === 200) {

            this.usuarioGlobal = data[0].res._body.code;
          } else if (data[0].res.status === 500) {
            console.log(data.toString());
          }
        },
        error => {
          console.log(error);
        });
    if (this.usuarioGlobal !== null) {
      if (this.usuarioGlobal.perfilUsuario === 'ADMINISTRADOR') {
        this.ususrioAutenticado = true;
        this.mostrarEmitter.emit(true);
        this.router.navigate(['/operador/listar']);
      } else if (this.usuarioGlobal.perfilUsuario === 'GERENTE') {
        this.ususrioAutenticado = true;
        this.mostrarEmitter.emit(true);
        this.router.navigate(['/pessoa/listar']);
      } else if (this.usuarioGlobal.perfilUsuario === 'ANALISTA') {
        this.ususrioAutenticado = true;
        this.mostrarEmitter.emit(true);
        this.router.navigate(['/pessoa/listar']);
      } else {
        this.mostrarEmitter.emit(false);
      }
    }
  }

  usuarioEstaAutenticado() {
    return this.ususrioAutenticado;
  }

  obtemDadosDoUsuario() {
    return this.usuarioGlobal;
  }
}
