import { Component } from '@angular/core';
import { ProductService } from '../product.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent {
  constructor(private ProductService: ProductService, private router: Router) {
  }

  products = this.ProductService.products;


  name: string = "";
  price: number = 0;
  quantity: number = 0;
  owner: string = "";

  addProduct() {
    this.router.navigate(['addProduct']);
  }

  buyProduct(id: number) {
    this.ProductService.products[id - 1].quantity--;
  }
}
