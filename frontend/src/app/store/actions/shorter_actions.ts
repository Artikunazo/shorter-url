import {Action} from '@ngrx/store';

export const SHORTER_URL = '[Shorter] Shorter Url';

export class ShorterUrl implements Action {
	readonly type = SHORTER_URL;

	constructor(public payload: any) {}
}

export type ShorterActions = ShorterUrl;
