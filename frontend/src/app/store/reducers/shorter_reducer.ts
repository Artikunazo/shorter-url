import {UrlData} from '../../models/urlData.model';
import * as fromShorterActions from '../actions/shorter_actions';

export interface ShorterState {
	data: UrlData;
	loading: boolean;
	error: any;
}

export const initialState = {
	data: {
		shortedUrl: '',
		originalUrl: '',
		user: '',
	},
	loading: false,
	error: '',
};

export function reducer(
	state = initialState,
	action: fromShorterActions.ShorterActions,
) {
	const shorterActionTypes = fromShorterActions.ShorterActionTypes;

	switch (action.type) {
		case shorterActionTypes.SHORTER_URL: {
			return {
				...state,
				data: {
					shortedUrl: '',
					originalUrl: action.payload.originalUrl,
					user: action.payload.user,
				},
				loading: true,
			};
		}

		case shorterActionTypes.SHORTER_URL_SUCCESS: {
			return {
				...state,
				data: {
					shortedUrl: action.payload.shortedUrl,
					originalUrl: action.payload.originalUrl,
					user: action.payload.user,
				},
				loading: false,
			};
		}

		case shorterActionTypes.SHORTER_URL_FAIL: {
			return {...state, error: action.payload, loading: false};
		}

		default: {
			return state;
		}
	}
}

export const getLoading = (state: ShorterState) => state.loading;
export const getError = (state: ShorterState) => state.error;
export const getUrlData = (state: ShorterState) => state.data;
