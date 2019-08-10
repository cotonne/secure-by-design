import {ChangeDetectionStrategy, Component, OnInit} from '@angular/core';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {switchMap} from 'rxjs/operators';
import {ProductService} from '../product.service';
import {Observable} from 'rxjs';
import {Product} from '../model/product';
import {FeedbackService} from '../feedback.service';
import {AuthenticationService} from '../authentication/authentication.service';
import {Feedback} from '../model/feedback';

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class ProductDetailComponent implements OnInit {
  product$: Observable<Product>;
  feedbacks$: Observable<Feedback[]>;
  columnsToDisplay = ['content'];
  feedback: string;

  constructor(
    private productService: ProductService,
    private feedbackService: FeedbackService,
    readonly authenticationService: AuthenticationService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  }

  ngOnInit() {
    this.product$ = this.route.paramMap.pipe(
      switchMap((params: ParamMap) => this.productService.getProduct(parseInt(params.get('id'), 10)))
    );
    this.feedbacks$ = this.route.paramMap.pipe(
      switchMap((params: ParamMap) => this.feedbackService.getFeedbackForProduct(parseInt(params.get('id'), 10)))
    );
  }

  postFeedback() {
    this.feedbackService
      .post(new Feedback(this.feedback))
      .subscribe(x => this.router.navigate(['/']));
  }
}
