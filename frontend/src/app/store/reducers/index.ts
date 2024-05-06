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
