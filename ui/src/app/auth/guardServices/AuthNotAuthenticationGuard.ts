import { Injectable } from '@angular/core';
import { Router, CanActivate, RouterStateSnapshot, ActivatedRouteSnapshot } from '@angular/router';
import { CurrentUserService } from '../CurrentUserService';


@Injectable()
export class AuthNotAuthenticationGuard implements CanActivate {

  constructor(public auth: CurrentUserService, public router: Router) {}

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    if (!this.auth.isAuthenticated()) { return true; }
    this.router.navigateByUrl('/');
    return false;
  }

}
