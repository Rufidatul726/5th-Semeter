import { Injectable } from '@angular/core';
import { Product } from './models/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  products: Product[] = [
    {id: 1, name: "product1", price: 10, quantity: 10, owner: "owner1"},
    {id: 2, name: "product2", price: 20, quantity: 20, owner: "owner2"},
    {id: 3, name: "product3", price: 30, quantity: 30, owner: "owner3"},
  ];
  constructor() { }
  addProduct(name: string, price: number, quantity: number, owner: string): void {
    const product: Product = {
      "id": this.products.length + 1,
      "name": name,
      "price": price,
      "quantity": quantity,
      "owner": owner
    }
    this.products.push(product);
  }

  

}
