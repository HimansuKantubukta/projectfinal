import { Component } from '@angular/core';
import { ItemsService } from '../items/items.service';
import { Router } from '@angular/router';

@Component({
  selector: 'adminhome',
  templateUrl: './adminhome.component.html',
  styleUrls: ['./adminhome.component.css']
})
export class AdminhomeComponent {
  
books : any=[]
constructor(private itemsService : ItemsService,private router:Router){}

ngOnInit(): void

  {
      this.itemsService.getAllItemDetails('').subscribe((data)=> this.books = data);

      console.log(this.books)

  }

  showBooksByTitle(title:string){

    const url='/search/'+title;

    this.itemsService.getAllItemDetails(url).subscribe((data)=> this.books = data);

  }
}
