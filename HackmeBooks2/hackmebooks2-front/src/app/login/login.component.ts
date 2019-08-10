import {Component, OnInit} from '@angular/core';
import {HttpClient, HttpHeaders, HttpResponse} from '@angular/common/http';
import {AuthenticationService} from '../authentication/authentication.service';
import {Router} from '@angular/router';
import {Observable} from 'rxjs';
import {FormControl, Validators} from '@angular/forms';
import {environment} from '../../environments/environment';

export class User {
  name: string;
  isAdmin: boolean;
}

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {


  username = new FormControl('', [Validators.required]);
  password = new FormControl('', [Validators.required]);

  constructor(
    private readonly http: HttpClient,
    private router: Router,
    private readonly authenticationService: AuthenticationService
  ) {
  }

  ngOnInit() {
  }

  login() {
    const model = {username: this.username.value, password: this.password.value};
    const url = `${environment.host}/user`;
    const headers = new HttpHeaders({
      authorization: 'Basic ' + btoa(model.username + ':' + model.password)
    });

    const configResponse: Observable<HttpResponse<User>> = this.http.get<User>(url, {
      headers: headers,
      observe: 'response' as 'response'
    });
    configResponse
      .subscribe((response: HttpResponse<User>) => {
        this.authenticationService.setUser(response.body);
        console.log(response);
        this.authenticationService.setSession(response.headers['JSESSIONID']);
        this.router.navigate(['']);
      }, () => {
        alert('Authentication failed.');
      });
  }

  getErrorMessage(fieldName: string) {
    return (this[fieldName] as FormControl).hasError('required') ? `${fieldName} required` : '';
  }
}
