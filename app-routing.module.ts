import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { CustomerComponent } from './customer/customer.component';
import { ProductComponent } from './product/product.component';




const routes: Routes = [
  
  {path:'customer',component:CustomerComponent},
  {path:'product',component:ProductComponent},
 
 
  


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
