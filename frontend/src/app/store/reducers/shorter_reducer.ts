import * as fromShorterActions from '../actions/shorter_actions';

export interface ShorterState {
	loading: boolean;
}

export const initialState = {
	loading: false,
};

export function reducer(
	state = initialState,
	action: fromShorterActions.ShorterActions,
) {
	return state;
}
