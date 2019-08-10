import {Injectable} from '@angular/core';
import {User} from '../login/login.component';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor() {
  }

  public setUser(user: User): void {
    sessionStorage.setItem('user', JSON.stringify(user));
  }

  public isAuthenticated(): boolean {
    return !!sessionStorage.getItem('user');
  }

  setSession(sessionId: string) {
    console.log(sessionId);
    sessionStorage.setItem('sessionId', sessionId);
  }
}
