import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { SearchComponent } from './search/search.component';
import { CartComponent } from './cart/cart.component';
import { LogoutComponent } from './logout/logout.component';
import { CategoryComponent } from './category/category.component';
import { ItemsComponent } from './items/items.component';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { AdminComponent } from './admin/admin.component';

import { NewnavComponent } from './newnav/newnav.component';
import { AdminhomeComponent } from './adminhome/adminhome.component';
import { AddbookComponent } from './addbook/addbook.component';
import { InventoryComponent } from './inventory/inventory.component';
import { DeletebookComponent } from './deletebook/deletebook.component';
import { OrderhistoryComponent } from './orderhistory/orderhistory.component';


const routes: Routes = [

  {
    path:"home",component:HomeComponent
  },
  {
    path:"newnav",component:NewnavComponent
  },
  {
    path:"addbook",component:AddbookComponent
  },
  {
    path:"adminhome",component:AdminhomeComponent

  },
  


  {
    path:"search",component:SearchComponent

  },
  {
    path:"category",component:CategoryComponent

  },
  {
    path:"admin",component:AdminComponent
  },

  {
    path:"cart",component:CartComponent
  },
  {
    path:"logout",component:LogoutComponent
  },
  {
    path:"items",component:ItemsComponent
  },
 
  {
    path:"",component:LoginComponent
  },
  {
    path:"inventory",component:InventoryComponent
  },
  {
    path:"registration",component:RegistrationComponent
  },
  {
    path:"deletebook",component:DeletebookComponent
  },
  {
    path:"orderhistory",component:OrderhistoryComponent 
  }
 
  

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
