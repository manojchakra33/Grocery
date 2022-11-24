import { Component, OnInit,EventEmitter,Output } from '@angular/core';
import { Status } from '../status';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {
 type:any="";
 @Output()
 status=new EventEmitter<any>();

  constructor() { }

  ngOnInit(): void {
  }
payment(type:any){
  console.log(type)
 
  this.status.emit(this.type);

}
}