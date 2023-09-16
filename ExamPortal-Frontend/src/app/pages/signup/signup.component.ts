import { MatSnackBar } from '@angular/material/snack-bar';
import { UserService } from './../../services/user.service';
import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css'],
})
export class SignupComponent implements OnInit {
  constructor(private userService:UserService, private snack:MatSnackBar) {}

  public user = {
    username: '',
    password: '',
    firstName: '',
    lastName: '',
    email: '',
    phone: '',
  };

  ngOnInit(): void {}
  formSubmit() {
    if(this.user.username == '' || this.user.username == null){
      this.snack.open("Username is required",'',{duration:3000,verticalPosition:'top',});
      return;
    }

    //adduser: userservice
    this.userService.addUser(this.user).subscribe(
      (data:any)=>{
        //success
        console.log(data);
        Swal.fire('Successfully Registered','User ID : '+data.id,'success');
        this.user.firstName = '',
        this.user.lastName = '',
        this.user.email = '',
        this.user.password = '',
        this.user.phone = '',
        this.user.username = ''
      },
      (error)=>{
        //error
        console.log(error)
        this.snack.open("Something went wrong",'',{duration:3000,verticalPosition:'top',});
      })
  }
}
