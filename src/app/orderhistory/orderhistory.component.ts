import { Component } from '@angular/core';
import { AppService } from '../app.service';

@Component({
  selector: 'orderhistory',
  templateUrl: './orderhistory.component.html',
  styleUrls: ['./orderhistory.component.css']
})
export class OrderhistoryComponent 
{
  orderItems:any= [];

  constructor(private appService:AppService){}

  ngOnInit(){
    this.appService.showOrderItems().subscribe((data)=>{this.orderItems=data;
    console.log(data)});
  }
}
