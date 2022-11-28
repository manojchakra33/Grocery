import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Observable } from 'rxjs';

import Products from '../Products';


import { UtilService } from '../util.service';


@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {
  ar = new Array<number>();
  cn: number = 0;
  constructor(private util: UtilService) { }

  productList:Products[]= [];
  
  count:number=0;


  tempCost:number=0;

  totalCost:any;
  e:any;
 
  category:any;
  flag:boolean=true;
  totalItemNumber:any;
 
  
  @Output()
  outcount = new EventEmitter<number>();
  

  ngOnInit(): void {
  let s=this.util.validateGrocery();
  s.subscribe((data)=>this.productList.push(data))
  console.log(this.productList)
  
  }

 
  }

  
