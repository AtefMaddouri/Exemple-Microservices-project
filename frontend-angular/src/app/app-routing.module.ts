import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ProductsComponent} from "./components/products/products.component";
import {AuthGuard} from "./security/AuthGuard";


const routes: Routes = [
  {path : "products", component : ProductsComponent, canActivate : [AuthGuard], data : {roles :['USER']}},
  // {path : "stocks", component : Customersomponent, canActivate : [AuthGuard], data : {roles : ['ADMIN']}},
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
