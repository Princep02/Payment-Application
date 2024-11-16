import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {

  name: string = "";
  phonenumber: string = "";
  email_id: string = "";
  password: string = "";
  loading: boolean = false;  // For loading state

  constructor(private router: Router, private http: HttpClient) { }

  completeSignup() {
    this.router.navigate(['/login']);
  }

  save() {
    this.loading = true;  // Set loading to true when the API request starts

    let bodyData = {
      "name": this.name,
      "phonenumber": this.phonenumber,
      "email_id": this.email_id,
      "password": this.password
    };

    this.http.post("http://localhost:8080/api/payment/users/signup", bodyData, { responseType: "text" }).subscribe(
      (resultData: any) => {
        console.log(resultData);
        alert("User signed up successfully!");
        this.loading = false;  // Set loading to false when request is completed
        this.router.navigate(['/login']);  // Navigate to login page
      },
      (error) => {
        console.error(error);
        this.loading = false;  // Set loading to false on error
        alert("An error occurred while signing up!");
      }
    );
  }
}
