import {Component, OnInit} from '@angular/core';
import {Observable} from 'rxjs';

@Component({
  selector: 'app-payment-tunnel',
  templateUrl: './payment-tunnel.component.html',
  styleUrls: ['./payment-tunnel.component.css']
})
export class PaymentTunnelComponent implements OnInit {
  paymentInformationCompleted = Observable.create(false);

  constructor() {
  }

  ngOnInit() {
  }

  validate() {

  }
}
