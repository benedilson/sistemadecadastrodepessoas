import { Injectable } from '@angular/core';
import {FormTelefoneComponent} from '../compartilhado/form-telefone/form-telefone.component';
import {ActivatedRouteSnapshot, CanDeactivate, RouterStateSnapshot} from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class TelefoneDeactivateGuardService implements CanDeactivate<FormTelefoneComponent>{

  constructor() { }

  canDeactivate(component: FormTelefoneComponent,
                currentRoute: ActivatedRouteSnapshot,
                state: RouterStateSnapshot): boolean {
    return window.confirm('Tem certeza que quer sair dessa página?');
  }
}
