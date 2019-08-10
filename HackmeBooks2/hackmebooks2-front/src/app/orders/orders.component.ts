import {Component, OnInit} from '@angular/core';
import {BehaviorSubject, Observable} from 'rxjs';
import {OrdersService} from '../orders.service';
import {Order} from '../model/order';
import {PageEvent} from '@angular/material';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {
  columnsToDisplay = ['order_number', 'credit_card_number', 'item', 'price'];
  orders$: Observable<Order[]>;

  // TODO
  length$: Observable<number> = new BehaviorSubject(0);

  constructor(
    readonly service: OrdersService
  ) {
  }

  ngOnInit() {
    this.orders$ = this.service.getOrders();
  }

  onPaging($event: PageEvent) {
    // TODO
  }
}
