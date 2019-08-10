import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material';
import {Product} from '../model/product';

@Component({
  selector: 'app-add-to-cart-quantity-dialog',
  templateUrl: './add-to-cart-quantity-dialog.component.html',
  styleUrls: ['./add-to-cart-quantity-dialog.component.css']
})
export class AddToCartQuantityDialogComponent implements OnInit {

  constructor(public dialogRef: MatDialogRef<AddToCartQuantityDialogComponent>,
              @Inject(MAT_DIALOG_DATA) public data: { product: Product, quantity: number }) {
  }

  cancel() {
    this.dialogRef.close();
  }

  ngOnInit(): void {
  }
}
