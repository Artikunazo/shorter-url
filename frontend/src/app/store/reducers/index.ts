import {
	ActionReducerMap,
	createFeatureSelector,
	createSelector,
} from '@ngrx/store';
import * as fromShorterReducer from './shorter_reducer';

export interface AppState {
	shorter: fromShorterReducer.ShorterState;
}

export const reducers: ActionReducerMap<AppState, any> = {
	shorter: fromShorterReducer.reducer,
};

/* SHORTER URL */
export const getShorterState =
	createFeatureSelector<fromShorterReducer.ShorterState>('shorter');

export const getLoading = createSelector(
	getShorterState,
	fromShorterReducer.getLoading,
);

export const getError = createSelector(
	getShorterState,
	fromShorterReducer.getError,
);

export const getUrlData = createSelector(
	getShorterState,
	fromShorterReducer.getUrlData,
);
