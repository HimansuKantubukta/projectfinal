import { Component } from '@angular/core';
import { DeletebookService } from './deletebook.service';
import { Router } from '@angular/router';

@Component({
  selector: 'deletebook',
  templateUrl: './deletebook.component.html',
  styleUrls: ['./deletebook.component.css']
})
export class DeletebookComponent {

  constructor(private add:DeletebookService,private router:Router){}



  onsubmit(txt1: string) {
   
  
   
    this.add.onsubmitService(txt1).subscribe(
      (response) =>
      {
        console.log("Successfull");
          alert("Book Deleted successfull")
          this.router.navigate(['adminhome']);

      },
      (error)=>
      {
          console.log("Not happening")
          alert("invalid book details")

      }
      
    )
  
   
  
  }
  

}
