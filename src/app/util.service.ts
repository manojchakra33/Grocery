import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from 'src/user';
import { Login } from 'src/login';
import { Address } from 'src/address';
import { HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})

export class UtilService {

  headers={
    headers: new HttpHeaders({
        'Content-Type': 'application/json'
    })
}

   
   p:any=""

  constructor(private httpClient:HttpClient) { }

 
  // registercustomer(reg:any):Observable<any>
  // {
  //   reg.forEach(User:u => {
  //     return this.httpClient.put<any>("http://localhost:8085/"+
  //   });
  // } 
  // "user":{
  //   "name":user.name,"mobilenumber":user.mobilenumber},

  addReg(user:User,login:Login,add:Address):Observable<any>{

    // console.log(JSON.stringify);
    console.log(user.name)

    
    return this.httpClient.post<any>("http://localhost:8085/regUser/",
   
    JSON.stringify({ 
      "name":user.name,
      "mobileNumber":user.mobilenumber,
      "address":{"addressLine1":add.addressLine1,
      "addressLine2":add.addressLine2,
      "city":add.city,
      "state":add.country,
      "country":add.country,
      "zipCode":add.zipcode},
      "login":{"userName":login.Username,
      "password":login.password,
      "role":""},
  }),
  {responseType:'text'as'json'});
     
   
   }
   
  
//   const headerOptions = new HttpHeaders();
//   headerOptions.set('Content-Type', 'application/json');
//   return this.httpClient.post<any>("http://localhost:8085/regUser",
//   ({ 
//     "name":user.name,
//     "mobileNumber":user.mobilenumber,
//     "address":{"addressLine1":add.addressLine1,
//     "addressLine2":add.addressLine2,
//     "city":add.city,
//     "state":add.country,
//     "country":add.country,
//     "zipCode":add.zipcode},
//     "login":{"userName":login.Username,
//     "password":login.password,
//     "role":""},
// }),
// {headers: headerOptions});
//  }
 
// }

showallproduct():Observable<any>{

  return this.httpClient.get<any>("http://localhost:8085/findAllproducts");
}


searchingProduct(name:any):Observable<any>{
  console.log(name+" entered into method");
  return this.httpClient.get<any>("http://localhost:8085/getProductsByName/"+ name);
}

}
