import { Component, OnInit } from '@angular/core';
import { UtilService } from '../util.service';
import { Product } from 'src/product';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private utilservice:UtilService) {
    
   }

  
//  Imagedata:String[]=[];
  
  ngOnInit(): void {
   
   // this.Repeat();
   //this.showSlides();
   this.showingproduct();
    
  }
 
  


  // __FunctionSlide() {
  //   this.Imagedata=["https://github.com/gilchrist01/imagesforslides/blob/main/slider_1.jpg?raw=true",
  //   "https://github.com/gilchrist01/imagesforslides/blob/main/slider_2.jpg?raw=true",
  //   "https://github.com/gilchrist01/imagesforslides/blob/main/slider_3.jpg?raw=true",
  //   "https://github.com/gilchrist01/imagesforslides/blob/main/slider_4.jpg?raw=true",
  //   "https://github.com/gilchrist01/imagesforslides/blob/main/slider_5.jpg?raw=true"];
   

  images = ["https://github.com/gilchrist01/imagesforslides/blob/main/slider_1.jpg?raw=true","https://github.com/gilchrist01/imagesforslides/blob/main/slider_2.jpg?raw=true", "https://github.com/gilchrist01/imagesforslides/blob/main/slider_3.jpg?raw=true", "https://github.com/gilchrist01/imagesforslides/blob/main/slider_4.jpg?raw=true", "https://github.com/gilchrist01/imagesforslides/blob/main/slider_5.jpg?raw=true"];



  







  
  productlist:any=[];

  showingproduct()
  {
    this.productlist=this.utilservice.showallproduct().subscribe(
      {next:(data)=>{
          this.products(data);
      },
    error:function(error){
    console.log(error);
  },
complete:()=>console.log("fetched")}
    );
  }

  productslisting:Product[]=[];

  products(data:any)
  {
    for(let i of data)
    {
      this.productslisting.push(i);
    }
  }
}