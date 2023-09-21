import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class DeletebookService {
  constructor (private httpclient:HttpClient){};

  onsubmitService(txt1:string):Observable<any>
  {
    
   const url='http://localhost:8097/book/delete';
   const data={
       
       "title": txt1,
       
       
  
   }
  
   console.log(data);
   const optional={
     Headers:new HttpHeaders({'content-Type':'application/json'}),
     responseType:'text' as 'json'
   };
  
   return this.httpclient.post(url,data,optional);
   
  }
  
  
  }
  