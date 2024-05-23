import {Component, OnDestroy, OnInit, inject} from '@angular/core';
import {Store} from '@ngrx/store';
import {Subscription} from 'rxjs';
import {ClipboardDirective} from '../common/clipboard.directive';
import {MaterialModule} from '../material/material.module';
import {UrlData} from '../models/urlData.model';
import * as fromStore from '../store';

@Component({
	selector: 'url-generated',
	standalone: true,
	imports: [MaterialModule, ClipboardDirective],
	templateUrl: './url-generated.component.html',
	styleUrl: './url-generated.component.scss',
})
export class UrlGeneratedComponent implements OnInit, OnDestroy {
	protected readonly store = inject(Store);

	protected readonly subscription = new Subscription();
	protected urlData!: UrlData;

	ngOnInit(): void {
		this.subscription.add(
			this.store.select(fromStore.getUrlData).subscribe({
				next: (response: UrlData) => {
					this.urlData = response;
				},
			}),
		);
	}

	ngOnDestroy(): void {
		this.subscription.unsubscribe();
	}
}
