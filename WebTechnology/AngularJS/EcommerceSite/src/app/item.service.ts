import { Injectable } from '@angular/core';
import { Item } from './item';

@Injectable({
  providedIn: 'root'
})
export class ItemService {

  constructor() {
    
  }

  items: Item[] =[
    {id: 1, name: "Iphone", price: 2000,  quantity: 3},
    {id: 2, name: "Macbook", price: 5000,  quantity: 2},
    {id: 3, name: "Oppo", price: 300,  quantity: 5}
  ]

  getItems(): Item[]{
      return this.items;
  }
}

