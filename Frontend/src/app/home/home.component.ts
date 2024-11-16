import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  standalone: true,
  imports: [FormsModule, CommonModule],
})
export class HomeComponent implements OnInit {
  accounts: any[] = [];
  userPhoneNumber: string = ''; // Store the user's phone number

  constructor(
    private authService: AuthService,
    private router: Router,
    private http: HttpClient
  ) {}

  ngOnInit() {
    // Retrieve the user from localStorage
    const user = JSON.parse(localStorage.getItem('user') || '{}');

    if (user && user.phoneNumber) {
      this.userPhoneNumber = user.phoneNumber; // Get phone number from stored user data
      this.fetchUserAccounts(); // Fetch accounts once phone number is available
    } else {
      console.error('No phone number found in localStorage');
    }
  }

  logout() {
    localStorage.removeItem('user');  // Clear user data
    this.router.navigate(['/login']); // Redirect to login page
  }

  transfer() {
    this.router.navigate(['/transfer']); // Navigate to the transfer page
  }

  fetchUserAccounts() {
    if (!this.userPhoneNumber) {
      console.error('Phone number is undefined or empty');
      return; // Avoid making the API call if the phone number is missing
    }

    console.log(`Fetching accounts for phone number: ${this.userPhoneNumber}`);

    // Retrieve token from localStorage
    const token = localStorage.getItem('authToken');
    if (!token) {
      console.error('No token found in localStorage');
      alert('You need to log in again.');
      this.router.navigate(['/login']); // Redirect to login if token is missing
      return;
    }

    // Set the Authorization header
    const headers = { Authorization: `Bearer ${token}` };

    // Make the HTTP GET request with headers
    this.http
      .get(`http://localhost:8080/api/payment/accounts/user/${this.userPhoneNumber}`, { headers })
      .subscribe(
        (data: any) => {
          this.accounts = data; // Set the accounts data
          console.log('Accounts fetched successfully', this.accounts);
        },
        (error) => {
          console.error('Error fetching accounts', error);
          // Handle errors based on status codes
          if (error.status === 400) {
            alert('Bad request: ' + error.message);
          } else if (error.status === 404) {
            alert('No accounts found for this phone number.');
          } else if (error.status === 401) {
            alert('Unauthorized: Your session has expired. Please log in again.');
            this.router.navigate(['/login']);
          } else {
            alert('An unexpected error occurred.');
          }
        }
      );
  }

}
