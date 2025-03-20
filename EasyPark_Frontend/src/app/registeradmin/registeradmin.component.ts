import { Component } from '@angular/core';
import { UserserviceService } from '../userservice.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-registeradmin',
  templateUrl: './registeradmin.component.html',
  styleUrls: ['./registeradmin.component.css']
})
export class RegisteradminComponent {

  constructor(private value:UserserviceService,private router:Router){

  }
  

  registeruser={
    username:"",
    password:"",
    city:"",
    email:""
  }
 
response:any
  userregister(){
    this.value.registeruser(this.registeruser).subscribe({
      next:(data)=>{
        if(data=="account created sucessfully"){
         this.router.navigate(['/admin'])
        }
        else{
           this.response=data
        }
      },
      error:()=>{
        
      }
    })
  }

}
