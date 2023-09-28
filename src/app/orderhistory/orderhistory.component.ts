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



  
  getDateFiveDaysAfter(order_date: string): Date 
  {
    const resultDate = new Date(order_date);
    resultDate.setDate(resultDate.getDate() + 5);
    return resultDate;
  }
}
