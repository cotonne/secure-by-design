import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Order} from './model/order';
import {BehaviorSubject, Observable} from 'rxjs';
import {AuthenticationService} from './authentication/authentication.service';
import {environment} from '../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class OrdersService {


  constructor(
    private client: HttpClient,
    private authenticationService: AuthenticationService
  ) {
  }

  public getOrders(): Observable<Order[]> {
    return this.client
      .get<Order[]>(`${environment.host}/orders`, {
        withCredentials: true
      });
  }

}
