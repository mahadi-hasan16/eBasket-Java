import { Component } from '@angular/core';
import { ProductCard } from '../../components/product-card/product-card';

@Component({
  selector: 'app-product-list-page',
  templateUrl: './product-list-page.html',
  styleUrl: './product-list-page.css',
  imports: [ProductCard],
})
export class ProductListPage {
  products = Array(100).fill(0);

}
