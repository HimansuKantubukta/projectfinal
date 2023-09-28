import { Component } from '@angular/core';
import { CartService } from './cart.service';
import { Data, Router } from '@angular/router';

@Component({
  selector: 'cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent
{
  cart:any[]=[];
  bookprice1:number=0;
  totalprice:number=0;
  constructor(private cartService : CartService,private router:Router){}

  ngOnInit():void
  {
    this.cartService.getCartItems().subscribe((data)=>{
      this.cart=data;
      this.getTotalPrice();
    });


    
  

  }
  getTotalPrice() {
    let totalPrice = 0;
    
    for (const item of this.cart) {
      if(item.quantity>0){
   
      this.bookprice1=item.quantity*item.bookprice;
      this.totalprice += this.bookprice1;
      
      console.log(item.quantity*item.bookprice);
      }
      else{
        this.Delete(item.bucketId);
        
      }

      
    }
    return totalPrice ;
  }

  incraesequantity(bucketid:number)
  {
    this.cartService.increasequantity(bucketid).subscribe(
      (response)=>

      {
        console.log("book increased successfully",response);
      },
      (error)=>
      {
        console.log("book not increased,error",error);
      }
    )
  
  }

  decraesequantity(bucketid:number)
  {
    this.cartService.decreasequantity(bucketid).subscribe(
      (response)=>

      {
        console.log("book decreased successfully",response);
      },
      (error)=>
      {
        console.log("book not decreased,error",error);
      }
    )
  }

  makepayment(){
    this.cartService.makePayment().subscribe((data)=>{
      console.log(data);
      if(data == 'OK'){
        alert("Payment successfull")
        window.location.reload();
        
      }
      else if(data == 'NOT_MODIFIED'){
        alert('Stock Unavailable');
      }
      else{
        alert('Session Experied');
      }
    });
     
   
      
  }

  Delete(bucketid:number){


    this.cartService.Delete(bucketid).subscribe(
      (response)=>
    {
      console.log("book deleted",response);
    alert("Deleted successfull");
    window.location.reload();
  },
  (error)=>
  {
    console.log("book not deleted",error);
  }
    )
}



}



 
  
  





