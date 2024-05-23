import {Clipboard} from '@angular/cdk/clipboard';
import {Injectable, inject} from '@angular/core';
import {MatSnackBar} from '@angular/material/snack-bar';

@Injectable({
	providedIn: 'root',
})
export class ClipboardService {
	protected readonly clipboard = inject(Clipboard);
	protected readonly matSnackBar = inject(MatSnackBar);

	constructor() {}

	copyToClipboard(content: string) {
		this.clipboard.copy(content);
		this.matSnackBar.open('Copied to clipboard', '', {duration: 1500});
	}
}
