import {Clipboard} from '@angular/cdk/clipboard';
import {Injectable, inject} from '@angular/core';

@Injectable({
	providedIn: 'root',
})
export class ClipboardService {
	protected readonly clipboard = inject(Clipboard);

	copyToClipboard(content: string) {
		this.clipboard.copy(content);
	}
}
