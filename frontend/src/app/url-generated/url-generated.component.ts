import {Component, input, signal} from '@angular/core';
import {MaterialModule} from '../material/material.module';

@Component({
	selector: 'url-generated',
	standalone: true,
	imports: [MaterialModule],
	templateUrl: './url-generated.component.html',
	styleUrl: './url-generated.component.scss',
})
export class UrlGeneratedComponent {}
