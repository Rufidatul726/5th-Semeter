import { Injectable } from '@angular/core';
import { User } from './models/model';

@Injectable({
  providedIn: 'root'
})
export class Service1Service {
  user : User[] = [];
    constructor() { }

  addUser(username:string,  email: string , password: string, password_confirm: string): void{
    const user : User = {
      "username": username,
      "email": email,
      "password": password,
      "password_confirm": password_confirm
    }
  }

}
