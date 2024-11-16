import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  phonenumber: string = '';
  password: string = '';

  constructor(private router: Router, private http: HttpClient) { }

  login() {
    // Log the input values to make sure they're being captured
    console.log("Phone Number:", this.phonenumber);
    console.log("Password:", this.password);

    // Create the request body data
    const bodyData = {
      phonenumber: this.phonenumber,
      password: this.password
    };

    // Make the POST request to the backend API
   this.http.post("http://localhost:8080/api/payment/users/login", bodyData)
     .subscribe({
       next: (resultData: any) => {
         console.log(resultData);
         if (resultData.message === "PhoneNumber not exists") {
           alert("Phone number does not exist.");
         } else if (resultData.message === "Login Success") {
           alert("Login Success");

           // Store the token
           localStorage.setItem('authToken', resultData.token); // Use sessionStorage if needed

           // Redirect to home page
           this.router.navigateByUrl('/login/home');
         } else {
           alert("Incorrect phone number or password.");
         }
       },
        error: (error: any) => {
          // Handle error in the HTTP request
          console.error("Login failed:", error);
          alert("An error occurred during login. Please check the console for details.");
        },
        complete: () => {
          // Optionally, log when the request is completed
          console.log("Login request completed.");
        }
      });
  }
}
