import { Component } from '@angular/core';
import { InventoryService } from './inventory.service';
import { Router } from '@angular/router';

@Component({
  selector: 'inventory',
  templateUrl: './inventory.component.html',
  styleUrls: ['./inventory.component.css']
})
export class InventoryComponent 
{

  inventory:any=[];


  
  constructor(private add:InventoryService,private router:Router){}

  showinventory()
  {
    
  }

  ngOnInit()
  {
    this.add.showinventory().subscribe((data)=>
    {
      this.inventory=data;
    }
    )


  }




}






