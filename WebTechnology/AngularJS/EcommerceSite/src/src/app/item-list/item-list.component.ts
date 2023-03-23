import { Component, OnInit } from '@angular/core';
import { ItemService } from '../item.service';
import { Item } from '../item';
import { Route, Router } from '@angular/router';

@Component({
  selector: 'app-item-list',
  templateUrl: './item-list.component.html',
  styleUrls: ['./item-list.component.css']
})
export class ItemListComponent implements OnInit{
  constructor(private itemservice: ItemService,private route: Router){ }
  myitems: Item[] =[];
  ngOnInit(): void{
    console.log(this.itemservice.getItems());
    this.myitems=this.itemservice.getItems();
  }

  requestItem(name:string) : void{
    alert("Item" + name + "Requested. ");
  }

  setItem(name:string):void{
    this.itemservice.decrementonBuy(name);
  }

  updateItem(name:string):void{
      this.itemservice.setItemToBeUpdated(name);
      this.route.navigate(["update"]);
  }
}
