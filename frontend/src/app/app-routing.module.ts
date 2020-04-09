import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from './paginas/login/login.component';
import {CriarOperadorComponent} from './paginas/criar-operador/criar-operador.component';
import {EditarOperadorComponent} from './paginas/editar-operador/editar-operador.component';
import {ListarOperadorComponent} from './paginas/listar-operador/listar-operador.component';
import {EditarPessoaComponent} from './paginas/editar-pessoa/editar-pessoa.component';
import {InserirPessoaComponent} from './paginas/inserir-pessoa/inserir-pessoa.component';
import {EditarTelefoneComponent} from './paginas/editar-telefone/editar-telefone.component';
import {InserirTelefoneComponent} from './paginas/inserir-telefone/inserir-telefone.component';
import {ListarPessoaComponent} from './paginas/listar-pessoa/listar-pessoa.component';
import {AuthGuard} from './guard/auth-guard';
import {TelefoneDeactivateGuardService} from './guard/telefone-deactivate-guard.service';
import {PessoaDeactivateGuardService} from './guard/pessoa-deactivate-guard.service';
import {OperadorDeactivateGuardService} from './guard/operador-deactivate-guard.service';
import {ListarPessoaTelefoneComponent} from './paginas/listar-pessoa-telefone/listar-pessoa-telefone.component';


const routes: Routes = [
  {path: '', component: LoginComponent},

  {path: 'operador/listar', component: ListarOperadorComponent, canActivate: [AuthGuard], canLoad: [AuthGuard]},
  {path: 'operador/criar', component: CriarOperadorComponent, canActivate: [AuthGuard],
    canDeactivate: [OperadorDeactivateGuardService], canLoad: [AuthGuard]},
  {path: 'operador/editar/:id', component: EditarOperadorComponent, canActivate: [AuthGuard],
    canDeactivate: [OperadorDeactivateGuardService], canLoad: [AuthGuard]},

  {path: 'pessoa/listar', component: ListarPessoaComponent, canActivate: [AuthGuard], canLoad: [AuthGuard]},
  {path: 'pessoa/byid', component: ListarPessoaTelefoneComponent, canActivate: [AuthGuard], canLoad: [AuthGuard]},
  {path: 'pessoa/editar/:id', component: EditarPessoaComponent, canActivate: [AuthGuard],
    canDeactivate: [PessoaDeactivateGuardService], canLoad: [AuthGuard]},
  {path: 'pessoa/criar', component: InserirPessoaComponent, canActivate: [AuthGuard],
    canDeactivate: [PessoaDeactivateGuardService], canLoad: [AuthGuard]},
  {path: 'telefone/editar/:id', component: EditarTelefoneComponent, canActivate: [AuthGuard],
    canDeactivate: [TelefoneDeactivateGuardService], canLoad: [AuthGuard]},
  {path: 'telefone/criar', component: InserirTelefoneComponent, canActivate: [AuthGuard],
    canDeactivate: [TelefoneDeactivateGuardService], canLoad: [AuthGuard]},

  {path: '**', redirectTo: ''}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
