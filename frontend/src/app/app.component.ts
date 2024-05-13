import {Component} from '@angular/core';
import {RouterOutlet} from '@angular/router';
import {FormUrlComponent} from './form-url/form-url.component';
import {UrlGeneratedComponent} from './url-generated/url-generated.component';
import {MaterialModule} from './material/material.module';

@Component({
	selector: 'app-root',
	standalone: true,
	imports: [RouterOutlet, FormUrlComponent, UrlGeneratedComponent],
	templateUrl: './app.component.html',
	styleUrl: './app.component.scss',
})
export class AppComponent {
	protected title = 'URL Shorter';

	protected urlShorted = true;
}