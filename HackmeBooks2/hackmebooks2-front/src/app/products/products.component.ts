import {ChangeDetectionStrategy, Component, OnInit} from '@angular/core';
import {BehaviorSubject, Subject} from 'rxjs';
import {MatDialog, PageEvent} from '@angular/material';
import {Product} from '../model/product';
import {ProductService} from '../product.service';
import {AddToCartQuantityDialogComponent} from '../add-to-cart-quantity-dialog/add-to-cart-quantity-dialog.component';
import {OrderLine} from '../model/order-line';
import {CartService} from '../cart.service';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class ProductsComponent implements OnInit {
  readonly products$: Subject<Product[]> = new BehaviorSubject([]);
  readonly columnsToDisplay = ['title', 'price', 'add'];
  readonly length$: Subject<number> = new BehaviorSubject(0);


  constructor(
    private cartService: CartService,
    private service: ProductService,
    private dialog: MatDialog) {
  }

  ngOnInit() {
    this.service.getPage(0, 5)
      .subscribe((x: { content: Product[], totalElements: number }) => {
        this.length$.next(x.totalElements);
        this.products$.next(x.content as Product[]);
      });
  }

  onPaging(event: PageEvent) {
    this.service.getPage(event.pageIndex, event.pageSize)
      .subscribe((x: { content: Product[], totalElements: number }) => {
        this.products$.next(x.content as Product[]);
      });
  }

  addToCart(product: Product) {
    const dialogRef = this.dialog.open(AddToCartQuantityDialogComponent, {
      width: '250px',
      data: {product: product, quantity: 1}
    });

    dialogRef.afterClosed().subscribe((result: { product: Product, quantity: number }) => {
      this.cartService.add(new OrderLine(result.product, result.quantity));
    });
  }
}
