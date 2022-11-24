import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CardComponent } from './card/card.component';
import { PaymentComponent } from './payment/payment.component';
import { SuccessComponent } from './success/success.component';

const routes: Routes = [
  {path:'Card',component:CardComponent},
  {path:'Payment',component:PaymentComponent},
  {path:'Success',component:SuccessComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents=[CardComponent,PaymentComponent,SuccessComponent]
