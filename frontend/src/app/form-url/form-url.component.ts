import {Component, inject} from '@angular/core';
import {MaterialModule} from '../material/material.module';
import {ReactiveFormsModule, FormBuilder, Validators} from '@angular/forms';

@Component({
	selector: 'form-url',
	standalone: true,
	imports: [MaterialModule, ReactiveFormsModule],
	templateUrl: './form-url.component.html',
	styleUrl: './form-url.component.scss',
})
export class FormUrlComponent {
	protected readonly formBuilder = inject(FormBuilder);
	protected readonly formUrl = this.formBuilder.group({
		url: this.formBuilder.control('', [Validators.required]),
	});

	shortUrl() {
		console.log(this.formUrl.value);
	}
}
