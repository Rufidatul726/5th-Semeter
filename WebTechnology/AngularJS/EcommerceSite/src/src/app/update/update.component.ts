import { Component } from '@angular/core';
import {FormsModule} from '@angular/forms';
import { ItemService } from '../item.service';
import { Item } from '../item';
import { Route, Router } from '@angular/router';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent {
  constructor(private itemservice: ItemService,private route: Router){ }

  items= new Item();

  ngOnInit(): void{
    this.items=this.itemservice.itemToBeUpdated;
  }

  update():void{
    this.items=this.itemservice.itemToBeUpdated;
  }
}
