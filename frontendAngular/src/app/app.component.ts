import { Component, OnInit } from '@angular/core';
import { Note } from './note';
import { NotesService } from './notes.service';
​
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
​
export class AppComponent implements OnInit{
  errMessage: string;
  title:string;
  text:string;
  notes:Array<Note>;
  note:Note=new Note();
  constructor(private util:NotesService) { }
​
  ngOnInit(): void {
    this.util.getNotes().subscribe({
      next:(data)=>this.notes=data,
      error:()=>this.errMessage="Http failure response for http://localhost:3000/notes: 404 Not Found"
    })
   }
 
​
​
  addnote(){
if(this.title && this.text){
  this.note.title=this.title;
  this.note.text=this.text;
}else{
  this.errMessage="Title and Text both are required fields";
   
}
​
    this.util.addNote(this.note).subscribe({
​
      next:(data)=>{if (data) {
        this.notes.push(this.note);
        this.note = new Note();
      } else {
        this.errMessage = 'Unable to add note.';
      }} ,
       error:()=> {
      this.errMessage = 'Http failure response for http://localhost:3000/notes: 404 Not Found';
    }
  
})
  }}