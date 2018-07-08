import { NgModule } from '@angular/core';
import { LayoutComponent } from './layoutComponent/layout.component';
import { LayoutService } from './service/LayoutService';
import { MatSidenavModule } from '@angular/material';
import { RouterModule } from '@angular/router';
import { MaterialModule } from '../commons/matereal/materialModule';
import { AuthenticatedDirective } from '../auth/authenticated.directive';
import { NotAuthenticatedDirective } from '../auth/not-authenticated.directive';
import { NotificationService } from './notifications/NotificationService';

@NgModule({
  declarations: [
    LayoutComponent,
    AuthenticatedDirective,
    NotAuthenticatedDirective
  ],
  exports: [
    LayoutComponent,
    AuthenticatedDirective,
    NotAuthenticatedDirective
  ],
  imports: [
    MaterialModule,
    MatSidenavModule,
    RouterModule
  ],
  providers: [LayoutService, NotificationService]
})
export class LayoutModule {
}
