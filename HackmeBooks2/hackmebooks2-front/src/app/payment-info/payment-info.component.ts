import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-payment-info',
  templateUrl: './payment-info.component.html',
  styleUrls: ['./payment-info.component.css']
})
export class PaymentInfoComponent implements OnInit {
  @Output()
  validate = new EventEmitter<boolean>();

  paymentFormGroup: FormGroup;

  paymentType: 'CARD' | 'ACCOUNT' = 'CARD';

  constructor(
    private client: HttpClient,
    private router: Router,
    private _formBuilder: FormBuilder
  ) {
  }

  ngOnInit() {
    this.paymentFormGroup = this._formBuilder.group({
      paymentType: ['', Validators.required],
      creditCardNumber: ['', Validators.required]
    });
  }

  purchase() {
    this.client.post('/order', {})
      .subscribe(receipt => this.router.navigate(['/receipt']));
  }
}
