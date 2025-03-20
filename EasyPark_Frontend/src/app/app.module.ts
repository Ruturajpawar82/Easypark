import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AdminloginComponent } from './adminlogin/adminlogin.component';
import { RegisteradminComponent } from './registeradmin/registeradmin.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { AddvehiclecategoryComponent } from './addvehiclecategory/addvehiclecategory.component';
import { FormsModule } from '@angular/forms';
import{HttpClient, HttpClientModule}from '@angular/common/http';
import { UpdatecategoryComponent } from './updatecategory/updatecategory.component';
import { MenuComponent } from './menu/menu.component';
import { AddvehicleComponent } from './addvehicle/addvehicle.component';
import { GetvehicleComponent } from './getvehicle/getvehicle.component';
import { GeneratebillComponent } from './generatebill/generatebill.component'
import { authGuard } from './guards/auth.guard';
import { GetalloutvehicleComponent } from './getalloutvehicle/getalloutvehicle.component';

@NgModule({
  declarations: [
    AppComponent,
    AdminloginComponent,
    RegisteradminComponent,
    DashboardComponent,
    AddvehiclecategoryComponent,
    UpdatecategoryComponent,
    MenuComponent,
    AddvehicleComponent,
    GetvehicleComponent,
    GeneratebillComponent,
    GetalloutvehicleComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
  
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
