import { Routes } from "@angular/router";
import { ProductHomePage } from "./pages/product-home-page/product-home-page";
import { ProductListPage } from "./pages/product-list-page/product-list-page";

export const productRoutes: Routes = [
    {path: '', component: ProductHomePage},
    {path: 'products', component: ProductListPage}
];