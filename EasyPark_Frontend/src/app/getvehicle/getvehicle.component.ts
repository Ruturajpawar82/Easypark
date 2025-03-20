import { Component } from '@angular/core';
import { UserserviceService } from '../userservice.service';

@Component({
  selector: 'app-getvehicle',
  templateUrl: './getvehicle.component.html',
  styleUrls: ['./getvehicle.component.css']
})
export class GetvehicleComponent {
  vehicle:any
  constructor(private service:UserserviceService){
    service.getvehicle().subscribe({
      next:(data)=>{
         this.vehicle=data
      },
      error:(error)=>{
        console.log(error)
      }
    })

  }
  
  
   
  

}
