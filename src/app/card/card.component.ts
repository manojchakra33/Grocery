import { Component, EventEmitter, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent implements OnInit {
  @Output()
  status=new EventEmitter<any>();
  
  constructor() { }

  ngOnInit(): void {
  }
  proceed(){
   
   
    this.status.emit(true);

}
cancel(){
  this.status.emit(false)
}
}
