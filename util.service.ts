import { Injectable } from '@angular/core';
import Grocery from './Products';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import Products from './Products';




@Injectable({
  providedIn: 'root'
})
export class UtilService {

  // count:number=0;

  productList=new BehaviorSubject<any>([]);

  products:Products[]=[];

  ar = new Array<number>();
  cn: number = 0;

  constructor(private httpClient: HttpClient) { }

  item(): Array<Products> {

   
    return this.products;
  }

  addcart(): number {
    this.cn = this.cn + 1;
    return this.cn;
  }

  adval(n: number): Array<number> {


    this.ar.push(n);
    return this.ar;
  }


  remar() {
    
    this.ar.splice(0, this.ar.length);
  }



validateGrocery():Observable<any> {

  return this.httpClient.get<any>("http://localhost:8089/findAllproducts");
}



}

  // getProductData(){

  //   return this.productList.asObservable();

  // }

  // setProduct(product:any){

  //  this.cartDataList.push(...product);
  //  this.productList.next(product)
  // }

  // addToCart(product:any){
  //   this.cartDataList.push(product);
  //   this.productList.next(this.cartDataList);
  //   this.getTotalAmount();
  //   console.log(this.cartDataList);
  // }
  // getTotalAmount(){

  //   let grandTotal=0;
  //   this.cartDataList.map((a:any)=>{

  //     grandTotal +=a.total;
  //   })
  // }


  


// findCategory(category:any):Observable<any>{
//   return this.httpClient.get("http://localhost:8089/findByCategory/" +category);
// }


