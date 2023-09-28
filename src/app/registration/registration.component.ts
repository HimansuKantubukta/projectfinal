import { Component } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { RegistrationService } from './registration.service';
import { Router } from '@angular/router';



@Component({
  selector: 'registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent
{
  constructor(private resgse:RegistrationService,private router:Router){}



  onsubmit(txt1: string, txt2: string, txt3: string, txt5: string, txt6: string, txt7: string) {
    const numericValue = parseInt(txt5);
  
    if (isNaN(numericValue)) {
      console.error("Invalid numeric input for txt5");
      return;
    }

    this.resgse.onsubmitService(txt1,txt2,txt3,numericValue,txt6,txt7).subscribe(
      (response) =>
      {
        console.log("Successfull");
          alert("Registration successfull")
          
          window.location.reload();


        
          
      },
      (error)=>
      {
          console.log("Not happening")
          alert("user already exists ")

      },
     
      
    )
  
   
  
  }
  

}
