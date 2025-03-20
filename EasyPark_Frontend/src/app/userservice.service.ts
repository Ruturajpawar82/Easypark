import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserserviceService {

  constructor(private http:HttpClient) { }
  url="http://localhost:8080/user/register"
  registeruser(registeruser:any):Observable<any>
  {
    return this.http.post(this.url,registeruser,{responseType:'text'});
  }
   url2="http://localhost:8080/user/login"
  loginuser(login:any):Observable<any>
  {
    return this.http.post(this.url2,login,{responseType:'text'})
  }
  url3="http://localhost:8080/admin/addcategory"

  addcategory(vehiclecategorys:any):Observable<any>
  {
     return this.http.post(this.url3,vehiclecategorys,{responseType:'text'})
  }
   url4="http://localhost:8080/admin/getallcategory"

   getallcategory():Observable<any>
   {
     return this.http.get(this.url4)
   }
   url5="http://localhost:8080/admin/getcategory"
   
   getcategorybyid(id:any):Observable<any>
   {
    return this.http.get(`${this.url5}/${id}`)
   }
   url6="http://localhost:8080/admin/updatecategory"
   
   updatecategory(vehicle:any):Observable<any>
   {
    return this.http.put(this.url6,vehicle,{responseType:'text'})
   }
   url7="http://localhost:8080/addvehicle"

   addvehicle(vehicle:any):Observable<any>
   {
       return this.http.post(this.url7,vehicle,{responseType:'text'})
   }
   url8="http://localhost:8080/getvehicle"

   getvehicle():Observable<any>
   {
    return this.http.get(this.url8)
   }
   url9="http://localhost:8080/generatebill/"

   generatebill(id:any):Observable<any>
   {
    return this.http.get(`${this.url9}${id}`,{responseType:'json'})
   }
    url10="http://localhost:8080/updatebill"
   paybill(bill:any):Observable<any>
   {
    return this.http.put(this.url10,bill,{responseType:'text'})
   }
   url11="http://localhost:8080/getalloutvehicle"
   outvehicle():Observable<any>
   {
    return this.http.get(this.url11)
   }
}

