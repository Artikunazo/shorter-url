import {Injectable, inject} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {UrlData} from '../models/urlData.model';
import {Observable} from 'rxjs';
import { environment } from '../../environments/environment.prod';

@Injectable({
	providedIn: 'root',
})
export class UrlsService {
	private readonly apiUrl = environment.apiUrl ?? 'http://localhost:8080/';
	private readonly httpClient = inject(HttpClient);

	requestNewShortUrl(data: UrlData): Observable<UrlData> {
		return this.httpClient.post<UrlData>(
			this.apiUrl + 'shorter-url/api/url/save',
			data,
		);
	}
}
