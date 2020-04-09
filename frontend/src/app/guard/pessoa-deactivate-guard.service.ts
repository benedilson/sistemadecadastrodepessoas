import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, CanDeactivate, RouterStateSnapshot} from '@angular/router';
import {FormPessoaComponent} from '../compartilhado/form-pessoa/form-pessoa.component';

@Injectable({
  providedIn: 'root'
})
export class PessoaDeactivateGuardService implements CanDeactivate < FormPessoaComponent > {

  canDeactivate(component: FormPessoaComponent,
                currentRoute: ActivatedRouteSnapshot,
                state: RouterStateSnapshot): boolean {
    return window.confirm('Tem certeza que quer sair dessa página?');
  }
};
