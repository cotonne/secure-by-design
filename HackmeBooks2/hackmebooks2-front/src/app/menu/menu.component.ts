import {Component, OnInit} from '@angular/core';
import {AuthenticationService} from '../authentication/authentication.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  constructor(readonly authenticationService: AuthenticationService) {
  }

  ngOnInit() {
  }

}
