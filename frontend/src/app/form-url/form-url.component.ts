import {Component, inject} from '@angular/core';
import {MaterialModule} from '../material/material.module';
import {ReactiveFormsModule, FormBuilder, Validators} from '@angular/forms';
import {UrlsService} from '../api/urls.service';
import {UrlData} from '../models/urlData.model';

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

	protected readonly formUrl = this.formBuilder.group({
		url: this.formBuilder.control('', [Validators.required]),
	});

	shortUrl() {
		const data: UrlData = {
			originalUrl: this.formUrl.value.url ?? '',
			date: new Date(),
			user: btoa(JSON.stringify(navigator)),
		};

		this.urlService.requestNewShortUrl(data).subscribe({
			next: (response: any) => {
				console.log(response);
			},
		});
	}
}
