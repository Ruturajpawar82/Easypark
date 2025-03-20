import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserserviceService } from '../userservice.service';

@Component({
  selector: 'app-generatebill',
  templateUrl: './generatebill.component.html',
  styleUrls: ['./generatebill.component.css']
})
export class GeneratebillComponent {
newid:any
  constructor(private route:ActivatedRoute,private service:UserserviceService){
       this.newid=route.snapshot.paramMap.get('id')
  }
  bill: any = {};

   ngOnInit(){

    this.service.generatebill(this.newid).subscribe({
      next:(data)=>{
          this.bill=data
          console.log(data)
        
          
      },
      error:(error)=>{
        console.log(error)
      }
    })

   }
   pay(){
    this.service.paybill(this.bill).subscribe({
      next:(data)=>{
        alert(data)
      },
      error:(error)=>{
        console.log(error)
      }
    })
   }
   

}
