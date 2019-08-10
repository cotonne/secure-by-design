import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-password-hint',
  templateUrl: './password-hint.component.html',
  styleUrls: ['./password-hint.component.css']
})
export class PasswordHintComponent implements OnInit {

  public username: string;

  constructor() { }

  ngOnInit() {
  }

  hint() {
    // ToDO
  }
}
