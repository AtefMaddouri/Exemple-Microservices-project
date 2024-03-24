import { Injectable } from '@angular/core';
import {KeycloakAuthGuard, KeycloakService} from "keycloak-angular";
import {ActivatedRouteSnapshot, Router, RouterStateSnapshot, UrlTree} from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class AuthGuard extends KeycloakAuthGuard{

  constructor(protected route: Router, protected keycloakService: KeycloakService) {
    super(route,keycloakService);
  }

  isAccessAllowed(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Promise<boolean | UrlTree> {
    return new Promise(async (resolve, reject) => {


      if (!this.authenticated) {
        this.keycloakService.login();
        resolve(false);
        return ;
      }

      const requiredRoles = route.data['roles'];
      let granted: boolean = false;

      if(!requiredRoles || requiredRoles.length === 0){
        granted = true;
      }else {
        granted = requiredRoles.every((role: string) => this.roles.includes(role));
      }

      resolve(granted);

    });
  }

}
