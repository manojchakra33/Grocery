import { Component, OnInit } from '@angular/core';
import { SearchProduct } from 'src/searchproduct';
import { UtilService } from '../util.service';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {

  constructor(private utilservice:UtilService) { }

  ngOnInit(): void {
  }

  

  search:any="";

  serachflag:boolean=true;

  product:SearchProduct[]=[];

  searchproductbyname()
  {
      
      console.log(this.search);
    // this.serachflag=false;
      return this.utilservice.searchingProduct(this.search).subscribe(
        {next:(data)=>{
            this.product=data;
        },
      error:function(error){
      console.log(error);
    },
  complete:()=>console.log("got it")}
      );
    
  }
}
