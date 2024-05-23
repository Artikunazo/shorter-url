import {ComponentFixture, TestBed} from '@angular/core/testing';

import {UrlGeneratedComponent} from './url-generated.component';

describe('UrlGeneratedComponent', () => {
	let component: UrlGeneratedComponent;
	let fixture: ComponentFixture<UrlGeneratedComponent>;

	beforeEach(async () => {
		await TestBed.configureTestingModule({
			imports: [UrlGeneratedComponent],
		}).compileComponents();

		fixture = TestBed.createComponent(UrlGeneratedComponent);
		component = fixture.componentInstance;
		fixture.detectChanges();
	});

	it('should create', () => {
		expect(component).toBeTruthy();
	});
});
