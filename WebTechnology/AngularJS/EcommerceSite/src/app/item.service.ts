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
    {id: 3, name: "Oppo", price: 300,  quantity: 5},
    {id: 4, name: "Vivo", price: 400,  quantity: 1},
    {id: 5, name: "Nokia", price: 390,  quantity: 0}
  ]

  getItems(): Item[]{
      return this.items;
  }

  decrementonBuy(name:string):void{
    let i;
    for(i=0;i<this.items.length;i++){
      if(name==this.items[i].name)break;
    }
    this.items[i].quantity--;
  }
}

