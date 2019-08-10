import {Injectable} from '@angular/core';
import {Product} from './model/product';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {map} from 'rxjs/operators';
import {environment} from '../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private client: HttpClient) {
  }

  getPage(page: number, size: number): Observable<{ content: Product[], totalElements: number }> {
    return this.client
      .get(`${environment.host}/products?page=${page}&size=${size}`)
      .pipe(map(_ => _ as { content: Product[], totalElements: number }));
  }

  getProduct(id: number): Observable<Product> {
    return this.client
      .get(`${environment.host} /products/${id}`)
      .pipe(map(_ => _ as Product));
  }
}
