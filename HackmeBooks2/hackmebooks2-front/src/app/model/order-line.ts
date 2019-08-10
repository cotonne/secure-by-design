import {Product} from './product';

export class OrderLine {
  constructor(
    readonly product: Product,
    readonly quantity: number) {

  }
}
