import { Component } from '@angular/core';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-addnewproduct',
  templateUrl: './addnewproduct.component.html',
  styleUrls: ['./addnewproduct.component.css']
})
export class AddnewproductComponent {
    constructor(private ProductService: ProductService) {}

    name: string = "";
    price: number = 0;
    quantity: number = 0;
    owner: string = "";

    addProduct(name: string, price: number, quantity: number, owner: string){
        this.ProductService.addProduct(this.name, this.price, this.quantity, this.owner);
        
    }
}
