import {Component, inject} from '@angular/core';
import {Store} from '@ngrx/store';
import {ClipboardDirective} from '../common/clipboard.directive';
import {CardModule} from 'primeng/card';
import {DividerModule} from 'primeng/divider';
import {ButtonModule} from 'primeng/button';
import * as fromStore from '../store';

@Component({
	selector: 'url-generated',
	standalone: true,
	imports: [CardModule, DividerModule, ButtonModule, ClipboardDirective],
	templateUrl: './url-generated.component.html',
	styleUrl: './url-generated.component.scss',
})
export class UrlGeneratedComponent {
	protected readonly store = inject(Store);
	protected readonly urlData = this.store.selectSignal(fromStore.getUrlData);
}
