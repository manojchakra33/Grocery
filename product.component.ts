import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import Category from '../Category';

import Products from '../Products';
import { UtilService } from '../util.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  

  @Input()
  pro:any;
  place:any;
  productList:any;

   @Output()
   proevent=new EventEmitter<any>();

   
  @Output()
  outcount = new EventEmitter<number>();

   @Output()
   
   pageevent=new EventEmitter<String>();
   
  constructor(private util: UtilService) { }
 


  ngOnInit(): void {
    console.log(this.pro)
  }

  cout:number=0;
  value:number=0;
  add(){
     this.cout= this.util.addcart();
     this.outcount.emit(this.cout);
     let f=  this.util.adval(this.place);
      
  }
  change(e:any){
    this.proevent.emit(e);
    this.pageevent.emit("customer")
    }

    
  
 

     
}


