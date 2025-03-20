import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserserviceService } from '../userservice.service';

@Component({
  selector: 'app-updatecategory',
  templateUrl: './updatecategory.component.html',
  styleUrls: ['./updatecategory.component.css']
})
export class UpdatecategoryComponent {

  constructor(private activate:ActivatedRoute,private service:UserserviceService,private route:Router){

  }
newid:any
data1:any
  ngOnInit(){
     this.newid=this.activate.snapshot.paramMap.get('id')
     console.log(this.newid)
     this.service.getcategorybyid(this.newid).subscribe({
      next:(data)=>{
        this.data1=data
      },
      error:(error)=>{
        console.log(error)
      }
     })
  }
 

  updatecategory(){
    this.service.updatecategory(this.data1).subscribe({
      next:(data)=>{
       alert(data)
       this.route.navigate(['/addvehiclecategory'])
      },
      error:(error)=>{
        console.log(error)
      }
    })
  }

}
