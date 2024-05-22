import {Injectable} from '@angular/core';
import {Observable, catchError, map, mergeMap, of, switchMap} from 'rxjs';
import {Action} from '@ngrx/store';
import {Actions, createEffect, ofType} from '@ngrx/effects';
import {UrlsService} from '../../api/urls.service';
import * as fromShorterActions from '../actions/shorter_actions';
import {UrlData} from '../../models/urlData.model';

@Injectable({
	providedIn: 'root',
})
export class ShortUrlEffects {
	private readonly shortUrlActionTypes = fromShorterActions.ShorterActionTypes;

	constructor(
		private actions$: Actions,
		private readonly urlsService: UrlsService,
	) {}

	shorterUrl$: Observable<Action> = createEffect(() => {
		return this.actions$.pipe(
			ofType(this.shortUrlActionTypes.SHORTER_URL),
			map((data: fromShorterActions.ShorterUrl) => data.payload),
			switchMap((data: UrlData) => {
				return this.urlsService.requestNewShortUrl(data).pipe(
					map((response: UrlData) => {
						return new fromShorterActions.ShorterUrlSuccess(response);
					}),
					catchError((error: any) => {
						return of(new fromShorterActions.ShorterUrlFail(error));
					}),
				);
			}),
		);
	});
}
