import {Directive, inject, input} from '@angular/core';
import {ClipboardService} from './clipboard.service';

@Directive({
	selector: '[clipboard]',
	standalone: true,
	host: {
		'(click)': 'copyToClipboard()',
	},
})
export class ClipboardDirective {
	protected readonly clipboardService = inject(ClipboardService);
	public clipboard = input<string>();

	copyToClipboard() {
		this.clipboardService.copyToClipboard(this.clipboard() ?? '');
	}
}
