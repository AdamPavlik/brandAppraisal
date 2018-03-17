import { NgModule } from '@angular/core';
import { LayoutComponent } from './layoutComponent/layout.component';
import { LayoutService } from './service/LayoutService';
import { MatSidenavModule } from '@angular/material';

@NgModule({
  declarations: [
    LayoutComponent
  ],
  exports: [
    LayoutComponent
  ],
  imports: [MatSidenavModule],
  providers: [LayoutService]
})
export class LayoutModule {
}
