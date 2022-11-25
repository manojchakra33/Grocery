import { Component, OnInit } from '@angular/core';
import { UtilService } from '../util.service';
import { User } from 'src/user';
import { Address } from 'src/address';
import { Login } from 'src/login';
import { NgForm } from '@angular/forms';


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

  // regForm=new FormGroup({

  //   id:new FormControl('',[Validators.required,Validators.pattern('[0-9]{3,5}')]),
  //   name:new FormControl('',[Validators.required,Validators.pattern('[A-Za-z]{1,20}')]),
  //   salary:new FormControl('',[Validators.required,Validators.min(10000),Validators.pattern('[0-9]{5,}')])

  // });

  register(f :NgForm)
  {
   
    this.user=new User(this.name,this.mobilenumber);
 
    this.address=new Address(this.addressline1,this.addressline2,this.city,this.state,this.country,this.zipcode);
    this.login=new Login(this.username,this.password);
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
