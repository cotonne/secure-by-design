import {Component, OnInit} from '@angular/core';
import {BehaviorSubject, Subject} from 'rxjs';

class Receipt {
  creditCardNumber: string;
  expiration: string;
  bankAccountNumber: string;
}

@Component({
  selector: 'app-receipt',
  templateUrl: './receipt.component.html',
  styleUrls: ['./receipt.component.css']
})
export class ReceiptComponent implements OnInit {

  receipt$: Subject<Receipt> = new BehaviorSubject(new Receipt());

  constructor() {
  }

  ngOnInit() {
  }

}
