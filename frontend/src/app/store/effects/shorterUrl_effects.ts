import {Injectable} from '@angular/core';
import {Observable, EMPTY, switchMap} from 'rxjs';
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

	shorterUrl$: Observable<Action> = createEffect(
		() =>
			this.actions$.pipe(
				ofType(this.shortUrlActionTypes.SHORTER_URL),
				switchMap(() => EMPTY),
			),
		{dispatch: false},
	);
}
