import {ApplicationConfig, importProvidersFrom} from '@angular/core';
import {provideRouter} from '@angular/router';

import {routes} from './app.routes';
import {provideAnimationsAsync} from '@angular/platform-browser/animations/async';
import {provideEffects} from '@ngrx/effects';
import {provideStore, provideState} from '@ngrx/store';
import * as fromShorterReducer from './store/reducers/shorter_reducer';
import {provideHttpClient} from '@angular/common/http';

import {effects} from './store';

export const appConfig: ApplicationConfig = {
	providers: [
		provideRouter(routes),
		provideAnimationsAsync(),
		provideAnimationsAsync(),
		provideEffects(effects),
		provideStore(),
		provideState({name: 'shorter', reducer: fromShorterReducer.reducer}),
		provideAnimationsAsync(),
		provideAnimationsAsync(),
		provideAnimationsAsync(),
		provideHttpClient(),
	],
};
