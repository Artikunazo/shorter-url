import {ApplicationConfig, importProvidersFrom} from '@angular/core';
import {provideRouter} from '@angular/router';

import {routes} from './app.routes';
import {provideAnimationsAsync} from '@angular/platform-browser/animations/async';
import {provideEffects} from '@ngrx/effects';
import {provideStore, provideState} from '@ngrx/store';
import * as fromShorterReducer from './store/reducers/shorter_reducer';
import {MaterialModule} from './material/material.module';
import {provideHttpClient} from '@angular/common/http';

export const appConfig: ApplicationConfig = {
	providers: [
		provideRouter(routes),
		provideAnimationsAsync(),
		provideAnimationsAsync(),
		provideEffects(),
		provideStore(),
		provideState({name: 'shorter', reducer: fromShorterReducer.reducer}),
		provideAnimationsAsync(),
		provideAnimationsAsync(),
		provideAnimationsAsync(),
		provideHttpClient(),
	],
};
