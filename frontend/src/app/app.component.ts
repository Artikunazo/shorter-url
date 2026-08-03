import {HttpClientModule} from '@angular/common/http';
import {Component, inject, computed} from '@angular/core';
import {ProgressSpinnerModule} from 'primeng/progressspinner';
import {RouterOutlet} from '@angular/router';
import {Store} from '@ngrx/store';
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
		ProgressSpinnerModule,
	],
	templateUrl: './app.component.html',
	styleUrl: './app.component.scss',
})
export class AppComponent {
	protected readonly store = inject(Store);
	protected title = 'URL Shorter';

	protected readonly isLoading = this.store.selectSignal(fromStore.getLoading);
	protected readonly urlData = this.store.selectSignal(fromStore.getUrlData);

	protected readonly isUrlShorted = computed(() => {
		const data = this.urlData();
		return data && data.shortedUrl.includes('https://new.domain');
	});
}
