import { Component } from '@angular/core';
import { UserserviceService } from '../userservice.service';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-adminlogin',
  templateUrl: './adminlogin.component.html',
  styleUrls: ['./adminlogin.component.css']
})
export class AdminloginComponent {

  constructor(private value:UserserviceService,private http:Router){

  }

  login={
    username:"",
    password:""
  }
  response:any
  loginuser(){
    this.value.loginuser(this.login).subscribe({
      next:(data)=>{
          if(data=="login sucessfully"){
          this.http.navigate(['/dashboard'])
          }
          else{
            this.response=data
          }
      },
      error:(error)=>{
    
      }
    })

  }

}
