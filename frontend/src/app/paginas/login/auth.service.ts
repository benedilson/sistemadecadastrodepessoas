import { Injectable } from '@angular/core';
import {Usuario} from '../../interfaces/usuario';
import {Router} from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private usuarioAutenticado: boolean = false;

  constructor(private route: Router) { }

  fazerLogin(usuario: Usuario) {
      if (usuario.nome === 'admin' && usuario.senha === '123') {
         this.usuarioAutenticado = true;

         this.route.navigate(['/']);
      } else {
        this.usuarioAutenticado = false;
      }
  }
}
