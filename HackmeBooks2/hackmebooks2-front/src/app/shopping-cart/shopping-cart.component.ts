import {Component, OnInit} from '@angular/core';
import {OrderLine} from '../model/order-line';
import {CartService} from '../cart.service';
import {PageEvent} from '@angular/material';
import {BehaviorSubject} from 'rxjs';

@Component({
  selector: 'app-shopping-cart',
  templateUrl: './shopping-cart.component.html',
  styleUrls: ['./shopping-cart.component.css']
})
export class ShoppingCartComponent implements OnInit {

  orderLines: OrderLine[];
  columnsToDisplay = ['title', 'price', 'quantity', 'total', 'action'];
  // TODO
  length$ = new BehaviorSubject(0);
  orderLines$ = new BehaviorSubject([]);

  constructor(private readonly cartService: CartService) {
  }

  ngOnInit() {
    this.orderLines = this.cartService.command();
  }

  deleteOrderLine(orderLine: OrderLine) {
    this.cartService.delete(orderLine);
  }

  onPaging($event: PageEvent) {
    // TODO
  }
}
