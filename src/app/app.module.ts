import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CartComponent } from './cart/cart.component';
import { CategoryComponent } from './category/category.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { ItemsComponent } from './items/items.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { SearchComponent } from './search/search.component';

import { SliderComponent } from './slider/slider.component';
import { HttpClientModule } from '@angular/common/http';
import { AppService } from './app.service';
import { FormsModule } from '@angular/forms';
import { RegistrationComponent } from './registration/registration.component';
import { RegistrationService } from './registration/registration.service';
import { ItemsService } from './items/items.service';
import { AdminComponent } from './admin/admin.component';
import { NewnavComponent } from './newnav/newnav.component';
import { AdminhomeComponent } from './adminhome/adminhome.component';
import { AddbookComponent } from './addbook/addbook.component';
import { InventoryComponent } from './inventory/inventory.component';
import { DeletebookComponent } from './deletebook/deletebook.component';
import { OrderhistoryComponent } from './orderhistory/orderhistory.component';


@NgModule({
  declarations: [
    AppComponent,
    
    CartComponent,
    CategoryComponent,
    
  
    HeaderComponent,
    HomeComponent,
    
    ItemsComponent,
    LoginComponent,
    LogoutComponent,
    SearchComponent,
    
    SliderComponent,
   RegistrationComponent,
   AdminComponent,
   NewnavComponent,
   AdminhomeComponent,
   AddbookComponent,
   InventoryComponent,
   DeletebookComponent,
   OrderhistoryComponent,
  
 
   
   
   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
  ],
  providers: [AppService,RegistrationService,ItemsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
