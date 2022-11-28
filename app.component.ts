import { Component } from '@angular/core';
import Grocery from './Products';
import { UtilService } from './util.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'onlinegrocery';
  // groceryList:Grocery[]=[];

  constructor(public util:UtilService){}
  ngOnInit(): void {
    
//  this.groceryList=this.util.getList();
  
}
 changePage(){

  
 }

}

