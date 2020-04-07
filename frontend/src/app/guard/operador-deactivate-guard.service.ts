import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, CanDeactivate, RouterStateSnapshot} from '@angular/router';
import {FormOperadorComponent} from '../compartilhado/form-operador/form-operador.component';

@Injectable({
  providedIn: 'root'
})
export class OperadorDeactivateGuardService implements CanDeactivate < FormOperadorComponent > {

  canDeactivate(component: FormOperadorComponent,
                currentRoute: ActivatedRouteSnapshot,
                state: RouterStateSnapshot): boolean {
    return window.confirm('Tem certeza que quer sair dessa página?');
  }
}
