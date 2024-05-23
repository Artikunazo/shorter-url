import {HttpClientModule} from '@angular/common/http';
import {Component, OnDestroy, OnInit, inject} from '@angular/core';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';
import {RouterOutlet} from '@angular/router';
import {Store} from '@ngrx/store';
import {Subscription} from 'rxjs';
import {FormUrlComponent} from './form-url/form-url.component';
import {UrlGeneratedComponent} from './url-generated/url-generated.component';

import {UrlData} from './models/urlData.model';
import * as fromStore from './store';

@Component({
	selector: 'app-root',
	standalone: true,
	imports: [
		RouterOutlet,
		FormUrlComponent,
		UrlGeneratedComponent,
		HttpClientModule,
		MatProgressSpinnerModule,
	],
	templateUrl: './app.component.html',
	styleUrl: './app.component.scss',
})
export class AppComponent implements OnInit, OnDestroy {
	protected readonly store = inject(Store);

	protected title = 'URL Shorter';
	protected readonly subscriptions = new Subscription();

	protected isLoading = false;
	protected isUrlShorted = false;

	ngOnInit(): void {
		this.subscriptions.add(
			this.store.select(fromStore.getLoading).subscribe({
				next: (response) => {
					this.isLoading = response;
				},
			}),
		);

		this.subscriptions.add(
			this.store.select(fromStore.getUrlData).subscribe({
				next: (response: UrlData) => {
					this.isUrlShorted =
						response.shortedUrl.includes('https://new.domain');
				},
			}),
		);
	}

	ngOnDestroy(): void {
		this.subscriptions.unsubscribe();
	}
}
