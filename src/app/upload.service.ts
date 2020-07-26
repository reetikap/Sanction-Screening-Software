import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UploadService {


  constructor(private httpClient:HttpClient) { }
  SERVER_URL: string = "http://localhost:8103/rest/sactions/upload";  

  public upload(formData) {
    console.log("upload service function is called")
    console.log(formData)
    return this.httpClient.post<FormData>(this.SERVER_URL, formData, {  
        reportProgress: true,  
        observe: 'events'  
      });  
  }
}
