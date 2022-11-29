import { Component, OnInit } from '@angular/core';
import { UtilService } from '../util.service';
import { User } from 'src/user';
import { Address } from 'src/address';
import { Login } from 'src/login';
import { NgForm } from '@angular/forms';
import { FormControl, FormGroup, Validators } from '@angular/forms';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private utilservice:UtilService) { }

  name:any;
  mobilenumber:any;
  addressline1:any;
  addressline2:any;
  city:any;
  state:any;
  country:any;
  zipcode:any;
  username:any;
  password:any;
  user:any;
  role:any;
  address:any;
  login:any;
  registerarray:any;

  ngOnInit(): void {
  }

  regForm=new FormGroup({

    name:new FormControl('',[Validators.required,Validators.pattern('[A-Za-z]{1,20}')]),
    mobilenumber:new FormControl('',[Validators.required,Validators.pattern('[0-9]{1,10}')]),
    addressline1:new FormControl('',[Validators.required]),
    addressline2:new FormControl('',[Validators.required]),
    city:new FormControl('',[Validators.required]),
    state:new FormControl('',[Validators.required]),
    country:new FormControl('',[Validators.required]),
    zipcode:new FormControl('',[Validators.required,Validators.pattern('[0-9]{1,6}')]),
    username:new FormControl('',[Validators.required]),
    password:new FormControl('',[Validators.required]),

  });
  

  // register(f :NgForm)
  // {
   
  //   this.user=new User(this.name,this.mobilenumber);
 
  //   this.address=new Address(this.addressline1,this.addressline2,this.city,this.state,this.country,this.zipcode);
  //   this.login=new Login(this.username,this.password);
  //   console.log(this.user);
  //   console.log(this.address);
  //   console.log(this.login);
    
  //   this.registerarray=this.utilservice.addReg(this.user,this.address,this.login)
  //   .subscribe({
  //     next: (data)=> {
  //       console.log(data);
  //       console.log("working  success"+data);
  //     }
  //   })
  //   console.log("hi hello");
  //   //  this.utilservice.registercustomer(reg);
    
  // }

  
  register()
  {
   
    this.user=new User(this.regForm.get("name")?.value,this.regForm.get("mobilenumber")?.value);
 
    this.address=new Address(this.regForm.get("addressline1")?.value,this.regForm.get("addressline2")?.value,this.regForm.get("city")?.value,this.regForm.get("state")?.value,this.regForm.get("country")?.value,this.regForm.get("zipcode")?.value);
    this.login=new Login(this.regForm.get("username")?.value,this.regForm.get("password")?.value);
    console.log(this.user);
    console.log(this.address);
    console.log(this.login);
    
    this.registerarray=this.utilservice.addReg(this.user,this.address,this.login)
    .subscribe({
      next: (data)=> {
        console.log(data);
        console.log("working  success"+data);
      }
    })
    console.log("hi hello");
    //  this.utilservice.registercustomer(reg);
    
  }
}
