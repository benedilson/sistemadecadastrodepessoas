import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {LoginComponent} from './paginas/login/login.component';
import {CriarOperadorComponent} from './paginas/criar-operador/criar-operador.component';
import {EditarOperadorComponent} from './paginas/editar-operador/editar-operador.component';
import {ListarOperadorComponent} from './paginas/listar-operador/listar-operador.component';
import {EditarPessoaComponent} from './paginas/editar-pessoa/editar-pessoa.component';
import {InserirPessoaComponent} from './paginas/inserir-pessoa/inserir-pessoa.component';
import {EditarTelefoneComponent} from './paginas/editar-telefone/editar-telefone.component';
import {InserirTelefoneComponent} from './paginas/inserir-telefone/inserir-telefone.component';
import {ListarPessoaComponent} from './paginas/listar-pessoa/listar-pessoa.component';
import {ListarTelefoneComponent} from './paginas/listar-telefone/listar-telefone.component';
import {AuthGuard} from './guard/auth-guard';


const routes: Routes = [
  {path: '', component: LoginComponent},

  {path: 'operador/listar', component: ListarOperadorComponent, canActivate: [AuthGuard]},
  {path: 'operador/criar', component: CriarOperadorComponent, canActivate: [AuthGuard]},
  {path: 'operador/editar/:id', component: EditarOperadorComponent, canActivate: [AuthGuard]},

  {path: 'pessoa/listar', component: ListarPessoaComponent, canActivate: [AuthGuard]},
  {path: 'pessoa/editar/:id', component: EditarPessoaComponent, canActivate: [AuthGuard]},
  {path: 'pessoa/criar', component: InserirPessoaComponent, canActivate: [AuthGuard]},

  {path: 'telefone/listar', component: ListarTelefoneComponent, canActivate: [AuthGuard]},
  {path: 'telefone/editar/:id', component: EditarTelefoneComponent, canActivate: [AuthGuard]},
  {path: 'telefone/criar', component: InserirTelefoneComponent, canActivate: [AuthGuard]},

  {path: '**', redirectTo: ''}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
