import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {map} from 'rxjs/operators';
import {Feedback} from './model/feedback';
import {environment} from '../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class FeedbackService {

  constructor(private readonly client: HttpClient) {
  }

  getFeedbackForProduct(productId: number): Observable<Feedback[]> {
    return this.client
      .get(`${environment.host}/feedbacks?product_id=${productId}`)
      .pipe(map(x => x as Feedback[]));
  }

  post(feedback: Feedback): Observable<Feedback[]> {
    return this.client
      .post<Feedback[]>(`${environment.host}/feedbacks`, feedback);
  }
}
