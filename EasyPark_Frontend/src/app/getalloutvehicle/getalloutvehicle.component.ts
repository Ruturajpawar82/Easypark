import { Component } from '@angular/core';
import { UserserviceService } from '../userservice.service';

@Component({
  selector: 'app-getalloutvehicle',
  templateUrl: './getalloutvehicle.component.html',
  styleUrls: ['./getalloutvehicle.component.css']
})
export class GetalloutvehicleComponent {
outvehicle:any
  constructor(private service:UserserviceService){

    service.outvehicle().subscribe({
      next:(data)=>{
        this.outvehicle=data
      },
      error:(error)=>{
        console.log(error)
      }
    })

  }
 
}
