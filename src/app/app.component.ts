import { Component } from '@angular/core';
import { PaymentComponent } from './payment/payment.component';
import { Status } from './status';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'paymentsuccess';
   paymentflag:Boolean=true;
   cardflag:Boolean=false;
   successflag:Boolean=false;
  proceed(flag:boolean){
   if(flag){
    this.cardflag=false;
    this.successflag=true;
   }else{
    this.paymentflag=true;
    this.cardflag=false;
   }
   
   
  }
  cancel(){
    this.cardflag=false;
    this.paymentflag=true;
    this.successflag=false;
  }
  paytype(s:any){
        if(s=="cash"){
          this.paymentflag=false;
          this.successflag=true;
        }else{
          this.paymentflag=false;
          this.cardflag=true;
        }
  }
  
}
