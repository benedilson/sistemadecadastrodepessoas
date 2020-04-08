import {Component} from '@angular/core';

import {AuthService} from './auth.service';
import {Usuario} from '../../classes/usuario';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  public usuario: Usuario = new Usuario();

  constructor(private authService: AuthService) {
  }

  onSubmit() {
      this.authService.fazerLogin(this.usuario);
  }

}
