import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class InventoryService {

  constructor(private httpClient:HttpClient ) {}

  showinventory()
  {
    const url="http://localhost:8097/invent/all";

    const options={
    "withCredentials":true

    }
    return this.httpClient.get(url,options);
  }


}
