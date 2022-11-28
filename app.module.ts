import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { UtilService } from './util.service';
import {HttpClientModule} from '@angular/common/http'
import { CustomerComponent } from './customer/customer.component';
import { FormsModule } from '@angular/forms';
import { ProductComponent } from './product/product.component';





@NgModule({
  declarations: [
    AppComponent,
    CustomerComponent,
    ProductComponent,
  
    
 
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
    
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
