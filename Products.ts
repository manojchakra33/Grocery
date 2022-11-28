import { VariableBinding } from "@angular/compiler";
import Category from "./Category";


export default class Products{
    constructor(public productId:number,public cost:number,public discount:number,public category:Category,public description:string,public rating:number,public image:string,public name:String){
        
    }
}