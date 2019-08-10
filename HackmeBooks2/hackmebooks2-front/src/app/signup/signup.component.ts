import {Component, OnInit} from '@angular/core';
import {environment} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';

class SignupModel {
  username: string;
  password: string;
  password_confirmation: string;
  first_name: string;
  last_name: string;
  email: string;
  phone_number: string;
  ssn: string;
  password_hint: string;
}

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  private model: SignupModel;

  constructor(private httpClient: HttpClient, private router: Router) {
  }

  ngOnInit() {
    this.model = new SignupModel();
  }

  signup() {
    console.log(this.model);
    this.httpClient
      .post(`${environment.host}/signup`, this.model)
      .subscribe(() => this.router.navigate(['/login']),
        () => {
        });
  }
}
