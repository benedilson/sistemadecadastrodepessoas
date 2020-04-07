import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './paginas/login/login.component';
import {AuthService} from './paginas/login/auth.service';
import {FormsModule} from '@angular/forms';
import { CriarOperadorComponent } from './paginas/criar-operador/criar-operador.component';
import {ErrorMsgComponent} from './compartilhado/error-msg/error-msg.component';
import { ListarOperadorComponent } from './paginas/listar-operador/listar-operador.component';
import { EditarOperadorComponent } from './paginas/editar-operador/editar-operador.component';
import { FormOperadorComponent } from './compartilhado/form-operador/form-operador.component';
import { FormPessoaComponent } from './compartilhado/form-pessoa/form-pessoa.component';
import { FormTelefoneComponent } from './compartilhado/form-telefone/form-telefone.component';
import { InserirPessoaComponent } from './paginas/inserir-pessoa/inserir-pessoa.component';
import { InserirTelefoneComponent } from './paginas/inserir-telefone/inserir-telefone.component';
import { EditarTelefoneComponent } from './paginas/editar-telefone/editar-telefone.component';
import { EditarPessoaComponent } from './paginas/editar-pessoa/editar-pessoa.component';
import { ListarPessoaComponent } from './paginas/listar-pessoa/listar-pessoa.component';
import { ListarTelefoneComponent } from './paginas/listar-telefone/listar-telefone.component';
import {AuthGuard} from './guard/auth-guard';

@NgModule({
  declarations: [
    AppComponent,
    ErrorMsgComponent,
    LoginComponent,
    CriarOperadorComponent,
    ListarOperadorComponent,
    EditarOperadorComponent,
    FormOperadorComponent,
    FormPessoaComponent,
    FormTelefoneComponent,
    InserirPessoaComponent,
    InserirTelefoneComponent,
    EditarTelefoneComponent,
    EditarPessoaComponent,
    ListarPessoaComponent,
    ListarTelefoneComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [AuthService, AuthGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
