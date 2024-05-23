import {Component, inject} from '@angular/core';
import {MaterialModule} from '../material/material.module';
import {ReactiveFormsModule, FormBuilder, Validators} from '@angular/forms';
import {UrlsService} from '../api/urls.service';
import {UrlData} from '../models/urlData.model';

import * as fromStore from '../store';
import {Store} from '@ngrx/store';

@Component({
	selector: 'form-url',
	standalone: true,
	imports: [MaterialModule, ReactiveFormsModule],
	templateUrl: './form-url.component.html',
	styleUrl: './form-url.component.scss',
})
export class FormUrlComponent {
	protected readonly formBuilder = inject(FormBuilder);
	protected readonly urlService = inject(UrlsService);
	protected readonly store = inject(Store);

	protected readonly formUrl = this.formBuilder.group({
		url: this.formBuilder.control('', [Validators.required]),
	});

	shortUrl() {
		const _navigator: any = {};

		for (let item in window.navigator) {
			_navigator[item] = (navigator as any)[item];
		}

		const data: UrlData = {
			originalUrl: this.formUrl.value.url ?? '',
			date: new Date(),
			user: btoa(JSON.stringify(_navigator)),
			shortedUrl: '',
		};

		this.store.dispatch(new fromStore.ShorterUrl(data));
	}
}
