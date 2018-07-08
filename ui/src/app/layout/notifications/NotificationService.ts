import { Injectable } from '@angular/core';
import { SnotifyService, SnotifyToastConfig } from 'ng-snotify';
import { SnotifyGlobalConfig } from 'ng-snotify/snotify/interfaces/SnotifGlobalConfig.interface';

@Injectable()
export class NotificationService {

  defaultConfig : SnotifyToastConfig = {
    timeout: 2000,
    showProgressBar: true,
    closeOnClick: true,
    pauseOnHover: true,
    position: 'rightTop'
  };

  globalConfig: SnotifyGlobalConfig = {
    maxOnScreen: 3,
    maxAtPosition: 3,
    newOnTop: false
  };

  constructor(private snotifyService: SnotifyService) {
    snotifyService.config.global = this.globalConfig;
  }

  info(title:string, body:string){
    this.snotifyService.info(body, title, this.defaultConfig);
  }

  error(title:string, body:string){
    this.snotifyService.error(body, title, this.defaultConfig);
  }

  warninng(title:string, body:string){
    this.snotifyService.warning(body, title, this.defaultConfig);
  }

  success(title:string, body:string){
    this.snotifyService.success(body, title, this.defaultConfig);
  }

}
