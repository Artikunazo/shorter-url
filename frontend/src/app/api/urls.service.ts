import {Injectable, inject} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {UrlData} from '../models/urlData.model';
import {Observable} from 'rxjs';

@Injectable({
	providedIn: 'root',
})
export class UrlsService {
	private readonly httpClient = inject(HttpClient);

	requestNewShortUrl(data: UrlData): Observable<UrlData> {
		return this.httpClient.post<UrlData>(
			'http://localhost:8080/shorter-url/api/url/save',
			data,
		);
	}
}
