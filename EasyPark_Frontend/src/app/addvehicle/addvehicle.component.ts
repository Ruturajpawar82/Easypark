import { Component } from '@angular/core';
import { UserserviceService } from '../userservice.service';
 

interface Category {
  category: string,
  hours:number,
  charges:number
}



@Component({
  selector: 'app-addvehicle',
  templateUrl: './addvehicle.component.html',
  styleUrls: ['./addvehicle.component.css']
})
export class AddvehicleComponent {

  curreentDate:Date =new Date();
  
  constructor(private category:UserserviceService){
      console.log(this.curreentDate);
  }
  categorys: Category[] = [];
  ngOnInit() {

    this.category.getallcategory().subscribe({
      next:(data)=>{
        this.categorys=data
      },
      error:(error)=>{
        console.log(error)
      }
     })
    

  }

  newvalue='';
  charge:any
   
fun2(){
  
  let selectedCategory = this.categorys.find(cat=>cat.category===this.newvalue)

  if(selectedCategory){
    this.charge=selectedCategory
    this.addvehicle.category=selectedCategory.category
    this.addvehicle.charges=selectedCategory.charges
    
  }
  
  
}
addvehicle={
  ownername:"",
  vehicleno:"",
  time:this.curreentDate,
  category:"",
  charges:0,
  
}
addvehicles(){
  this.category.addvehicle(this.addvehicle).subscribe({
    next:(data)=>{
      alert(data)
    },
    error:(error)=>{
      
      console.log(error)
    }
  })
}
}
