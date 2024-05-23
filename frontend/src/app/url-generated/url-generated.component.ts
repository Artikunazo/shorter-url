import {Component, OnDestroy, OnInit, inject} from '@angular/core';
import {MaterialModule} from '../material/material.module';
import {Subscription} from 'rxjs';
import {Store} from '@ngrx/store';
import * as fromStore from '../store';
import {UrlData} from '../models/urlData.model';

@Component({
	selector: 'url-generated',
	standalone: true,
	imports: [MaterialModule],
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
