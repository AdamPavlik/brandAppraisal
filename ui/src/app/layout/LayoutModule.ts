import { NgModule } from '@angular/core';
import { LayoutComponent } from './layoutComponent/layout.component';
import { LayoutService } from './service/LayoutService';
import { MatSidenavModule } from '@angular/material';
import { RouterModule } from '@angular/router';
import { MaterialModule } from '../commons/matereal/materialModule';

@NgModule({
  declarations: [
    LayoutComponent
  ],
  exports: [
    LayoutComponent
  ],
  imports: [
    MaterialModule,
    MatSidenavModule,
    RouterModule
  ],
  providers: [LayoutService]
})
export class LayoutModule {
}
