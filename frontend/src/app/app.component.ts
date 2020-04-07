import {Component, OnInit} from '@angular/core';
import {AuthService} from './paginas/login/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'Sistema de Cadastro';
  mostrar = false;

  constructor(private authService: AuthService) {
  }

  ngOnInit() {
    this.authService.mostrarEmitter.subscribe(
      mostrar => this.mostrar = mostrar
    );
  }

}
