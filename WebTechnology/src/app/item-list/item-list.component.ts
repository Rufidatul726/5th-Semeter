import { Component, OnInit } from '@angular/core';
import { ItemService } from '../item.service';
import { Item } from '../item';

@Component({
  selector: 'app-item-list',
  templateUrl: './item-list.component.html',
  styleUrls: ['./item-list.component.css']
})
export class ItemListComponent implements OnInit{
  constructor(private itemservice: ItemService){ }
  myitems: Item[] =[];
  ngOnInit(): void{
    console.log(this.itemservice.getItems());
    this.myitems=this.itemservice.getItems();
  }
}
