import { Component } from '@angular/core';
import { UserserviceService } from '../userservice.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-addvehiclecategory',
  templateUrl: './addvehiclecategory.component.html',
  styleUrls: ['./addvehiclecategory.component.css']
})
export class AddvehiclecategoryComponent {

  constructor(private service:UserserviceService, private rout:Router){

  }

  vehiclecategorys={

    category:"",
    hours:"1",
    charges:""

  }
   response:any
   
  vehiclecategory(){
       this.service.addcategory(this.vehiclecategorys).subscribe({
        next:(data)=>{
         if(data=="category added sucessfully"){
          alert(data)
         }
         else{
          this.response=data
         }
        },
        error:(error)=>{
          console.log(error)
        }
       })
       
  }
  getalldatas:any
  getalldata(){
    this.service.getallcategory().subscribe({
         next:(data)=>{
            this.getalldatas=data
         },
         error:(error)=>{
           console.log(error)
         }
        })
 }

  update(){
      this.rout.navigate(['/addvehiclecategory'])
  }



}
