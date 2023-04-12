import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Service1Service } from '../service1.service';
import {User} from "../models/model";

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent {
   
  constructor(private Service1Service: Service1Service) {}

  username: string = "";
  email: string = "";
  password: string = "";
  password_confirm: string = "";
  
  addUser(){
    this.Service1Service.addUser(this.username, this.email, this.password, this.password_confirm);
    console.log(this.email);
  }

  
}
