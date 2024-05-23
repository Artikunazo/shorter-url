import {Action} from '@ngrx/store';
import {UrlData} from '../../models/urlData.model';

export enum ShorterActionTypes {
	SHORTER_URL = '[Shorter] Shorter Url',
	SHORTER_URL_SUCCESS = '[Shorter] Shorter Url Success',
	SHORTER_URL_FAIL = '[Shorter] Shorter Url Fail',
}

export class ShorterUrl implements Action {
	readonly type = ShorterActionTypes.SHORTER_URL;

	constructor(public payload: UrlData) {}
}

export class ShorterUrlSuccess implements Action {
	readonly type = ShorterActionTypes.SHORTER_URL_SUCCESS;

	constructor(public payload: UrlData) {}
}

export class ShorterUrlFail implements Action {
	readonly type = ShorterActionTypes.SHORTER_URL_FAIL;

	constructor(public payload: any) {}
}

export type ShorterActions = ShorterUrl | ShorterUrlSuccess | ShorterUrlFail;
