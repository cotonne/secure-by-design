import {Component, OnInit} from '@angular/core';
import {BehaviorSubject, Observable, Subject} from 'rxjs';
import {User} from '../login/login.component';

class Role {
  id: number;
  label: string;
}

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  roles$: Subject<Role[]> = new BehaviorSubject([] as Role[]);
  // TODO
  user$: Observable<User> = new BehaviorSubject(new User());

  constructor() {
  }

  ngOnInit() {
  }

}
