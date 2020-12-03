import { Component, OnInit } from '@angular/core';
import { UploadService } from 'src/app/upload.service';
import { HttpEventType, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import { RegistrationService } from '../registration.service';
import { ShowtransactionsComponent } from '../showtransactions/showtransactions.component';
@Component({
  selector: 'app-upload',
  templateUrl: './upload.component.html',
  styleUrls: ['./upload.component.css']
})
export class UploadComponent implements OnInit {
  selectedFiles: FileList;
  currentFile: File;
  progress = 0;
  message = '';

  fileInfos: Observable<any>;
  obj:ShowtransactionsComponent;
  constructor(private uploadService: UploadService ,private router: Router,public loginService:RegistrationService) { }

  
  
  ngOnInit(): void {
    this.fileInfos = this.uploadService.getFiles();

  }

  onclicktransaction(){
    
    this.router.navigate(["/showtransactions"]);
  }
  selectFile(event) {
    this.selectedFiles = event.target.files;
  }
  upload() {
    this.progress = 0;
  
    this.currentFile = this.selectedFiles.item(0);
    this.uploadService.upload(this.currentFile).subscribe(
      event => {
        if (event.type === HttpEventType.UploadProgress) {
          this.progress = Math.round(100 * event.loaded / event.total);
        } else if (event instanceof HttpResponse) {
          this.message = "Uploaded Successfully";
          this.fileInfos = this.uploadService.getFiles();
        }
      },
      err => {
        this.progress = 0;
        this.message = 'Could not upload the file!';
        this.currentFile = undefined;
      });
  
    this.selectedFiles = undefined;
  }
}