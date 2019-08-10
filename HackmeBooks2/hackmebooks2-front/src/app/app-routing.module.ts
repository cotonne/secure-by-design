import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {WelcomeComponent} from './welcome/welcome.component';
import {LoginComponent} from './login/login.component';
import {ForgotYourPasswordComponent} from './forgot-your-password/forgot-your-password.component';
import {SignupComponent} from './signup/signup.component';
import {ProductDetailComponent} from './product-detail/product-detail.component';
import {ProductsComponent} from './products/products.component';
import {OrdersComponent} from './orders/orders.component';
import {PaymentInfoComponent} from './payment-info/payment-info.component';
import {PaymentTunnelComponent} from './payment-tunnel/payment-tunnel.component';

const routes: Routes = [
  {path: 'welcome', component: WelcomeComponent},
  {path: 'login', component: LoginComponent},
  {path: 'forgot-your-password', component: ForgotYourPasswordComponent},
  {path: 'signup', component: SignupComponent},
  {path: 'my-orders', component: OrdersComponent},
  {path: 'view-cart', component: PaymentTunnelComponent},
  {path: 'check-out', component: SignupComponent}, // TODO
  {path: 'product/:id', component: ProductDetailComponent},
  {path: 'products', component: ProductsComponent},
  {path: 'payment-info', component: PaymentInfoComponent},
  {
    path: '',
    redirectTo: '/welcome',
    pathMatch: 'full'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
