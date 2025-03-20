import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegisteradminComponent } from './registeradmin/registeradmin.component';
import { AdminloginComponent } from './adminlogin/adminlogin.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { AddvehiclecategoryComponent } from './addvehiclecategory/addvehiclecategory.component';
import { UpdatecategoryComponent } from './updatecategory/updatecategory.component';
import { AddvehicleComponent } from './addvehicle/addvehicle.component';
import { GetvehicleComponent } from './getvehicle/getvehicle.component';
import { GeneratebillComponent } from './generatebill/generatebill.component';
import { authGuard } from './guards/auth.guard';
import { GetalloutvehicleComponent } from './getalloutvehicle/getalloutvehicle.component';

const routes: Routes = [
  {
    path: '', redirectTo: 'admin', pathMatch: 'full' 
  },
  {
    path:'register',component:RegisteradminComponent,
  },
  {
    path:'admin',component:AdminloginComponent
  },
  {
    path:'dashboard',component:DashboardComponent
  },
  {
    path:'addvehiclecategory',component:AddvehiclecategoryComponent,
  },
  {
    path:'addvehiclecategory/:id',component:UpdatecategoryComponent,
  },
  {
    path:'addvehicle',component:AddvehicleComponent
  },
  {
    path:'getvehicle',component:GetvehicleComponent
  },
  {
    path:'generatebill/:id',component:GeneratebillComponent
  },
  {
    path:'outvehicle',component:GetalloutvehicleComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
