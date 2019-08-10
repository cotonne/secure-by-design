import {Injectable} from '@angular/core';
import {OrderLine} from './model/order-line';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  constructor() {
  }

  add(orderLine: OrderLine) {
    const orderLines: OrderLine[] = JSON.parse(sessionStorage.getItem('command') || '[]');
    this.saveOrderLines([...orderLines, orderLine]);
  }

  command(): OrderLine[] {
    return this.loadOrderLines();
  }

  delete(orderLine: OrderLine) {
    const orderLines: OrderLine[] = this.loadOrderLines();
    this.saveOrderLines(orderLines.filter(x => x !== orderLine));
  }

  private saveOrderLines(value) {
    sessionStorage.setItem('command', JSON.stringify(value));
  }

  private loadOrderLines() {
    return JSON.parse(sessionStorage.getItem('command') || '[]');
  }
}
