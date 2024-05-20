import {Injectable, inject} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {UrlData} from '../models/urlData.model';

@Injectable({
	providedIn: 'root',
})
export class UrlsService {
	private readonly httpClient = inject(HttpClient);

	requestNewShortUrl(data: UrlData) {
		return this.httpClient.post(
			'http://localhost:8080/shorter-url/api/url/save',
			data,
		);
	}
}
