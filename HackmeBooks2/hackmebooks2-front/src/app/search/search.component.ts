import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../environments/environment';
import {Product} from '../model/product';
import {Observable} from 'rxjs';
import {map} from 'rxjs/operators';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  columnsToDisplay = ['title', 'price'];

  model: string;
  products$: Observable<Product[]>;

  constructor(private readonly httpClient: HttpClient) {
  }

  ngOnInit() {
  }

  search() {
    this.products$ = this.httpClient
      .get(`${environment.host}/products/_search?q=${this.model}`)
      .pipe(map((products: Product[]) => {
        console.log(products.slice(0, 5));
        return products.slice(0, 5);
      }));
  }
}
