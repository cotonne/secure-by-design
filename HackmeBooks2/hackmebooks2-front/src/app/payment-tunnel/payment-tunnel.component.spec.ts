import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PaymentTunnelComponent } from './payment-tunnel.component';

describe('PaymentTunnelComponent', () => {
  let component: PaymentTunnelComponent;
  let fixture: ComponentFixture<PaymentTunnelComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PaymentTunnelComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PaymentTunnelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
