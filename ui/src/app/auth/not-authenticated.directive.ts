import { Directive, ElementRef, Input, OnInit } from '@angular/core';
import { environment } from '../../environments/environment';
import { isNullOrUndefined } from 'util';
import { LocalStorageService } from '../commons/localStorage';

@Directive({
  selector: 'not-authenticated'
})
export class NotAuthenticatedDirective implements OnInit {


  constructor(private element: ElementRef,
              private storage: LocalStorageService) {
  }

  ngOnInit(): void {
    let token = this.storage.get(environment.TOKEN_NAME);
    if (!isNullOrUndefined(token)) {
      this.removeElements(this.element);
    }
  }

  private removeElements(elements) {
    let element = elements.nativeElement;
    while (element.firstChild) {
      element.removeChild(element.firstChild);
    }
    element.remove();
  }

}
