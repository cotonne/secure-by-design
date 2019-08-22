import {Component, OnInit} from '@angular/core';
import {environment} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';
import {FormControl, FormGroup, Validators} from '@angular/forms';

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
  form = new FormGroup({
    email: new FormControl('', [
      Validators.required,
      Validators.email,
    ]),
    username: new FormControl('', [Validators.required]),
    password: new FormControl('', Validators.required),
    password_confirmation: new FormControl('', Validators.required),
    first_name: new FormControl('', [Validators.required]),
    last_name: new FormControl('', [Validators.required]),
    phone_number: new FormControl(),
    ssn: new FormControl(),
    password_hint: new FormControl()
  }, {validators: passwordMatchValidator});

  constructor(private httpClient: HttpClient, private router: Router) {
  }

  ngOnInit() {
  }

  signup() {
    this.httpClient
      .post(`${environment.host}/signup`, this.form.value)
      .subscribe(() => this.router.navigate(['/login']),
        () => {
        });
  }
}

function passwordMatchValidator(g: FormGroup) {
  return g.get('password').value === g.get('password_confirmation').value
    ? null : {'mismatch': true};
}
