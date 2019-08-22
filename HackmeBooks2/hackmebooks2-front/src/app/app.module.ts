import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {DemoMaterialModule} from '../material-module';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {WelcomeComponent} from './welcome/welcome.component';
import {LoginComponent} from './login/login.component';
import {SearchComponent} from './search/search.component';
import {ForgotYourPasswordComponent} from './forgot-your-password/forgot-your-password.component';
import {SignupComponent} from './signup/signup.component';
import { PasswordHintComponent } from './password-hint/password-hint.component';
import { ActiveUsersComponent } from './active-users/active-users.component';
import { OrdersComponent } from './orders/orders.component';
import { ProductDetailComponent } from './product-detail/product-detail.component';
import { ProductsComponent } from './products/products.component';
import { ReceiptComponent } from './receipt/receipt.component';
import { ShoppingCartComponent } from './shopping-cart/shopping-cart.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { AddToCartQuantityDialogComponent } from './add-to-cart-quantity-dialog/add-to-cart-quantity-dialog.component';
import { PaymentInfoComponent } from './payment-info/payment-info.component';
import { MenuComponent } from './menu/menu.component';
import { PaymentTunnelComponent } from './payment-tunnel/payment-tunnel.component';
import { registerLocaleData } from '@angular/common';
import localeEn from '@angular/common/locales/en';

registerLocaleData(localeEn, 'us');

@NgModule({
  declarations: [
    AppComponent,
    WelcomeComponent,
    LoginComponent,
    SearchComponent,
    ForgotYourPasswordComponent,
    SignupComponent,
    PasswordHintComponent,
    ActiveUsersComponent,
    OrdersComponent,
    ProductDetailComponent,
    ProductsComponent,
    ReceiptComponent,
    ShoppingCartComponent,
    UserProfileComponent,
    AddToCartQuantityDialogComponent,
    PaymentInfoComponent,
    MenuComponent,
    PaymentTunnelComponent,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    DemoMaterialModule
  ],
  entryComponents: [
    AddToCartQuantityDialogComponent
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
