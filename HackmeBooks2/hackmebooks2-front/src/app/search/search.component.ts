import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../environments/environment';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  model: string;

  constructor(private readonly httpClient: HttpClient) {
  }

  ngOnInit() {
  }

  search() {
    this.httpClient
      .get(`${environment.host}/products/_search?q=${this.model}`)
      .subscribe(); // TODO DO SOMETHING!!!
  }

}
