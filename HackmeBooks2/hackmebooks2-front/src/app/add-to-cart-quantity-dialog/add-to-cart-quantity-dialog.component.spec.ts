import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddToCartQuantityDialogComponent } from './add-to-cart-quantity-dialog.component';

describe('AddToCartQuantityDialogComponent', () => {
  let component: AddToCartQuantityDialogComponent;
  let fixture: ComponentFixture<AddToCartQuantityDialogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddToCartQuantityDialogComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddToCartQuantityDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
