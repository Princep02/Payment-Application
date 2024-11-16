import { Component } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'transfer',
  templateUrl: './transfer.component.html',
  styleUrls: ['./transfer.component.css'],
  standalone: true,
  imports: [FormsModule, CommonModule]
})
export class TransferComponent {
  fromAccount: number = 0;
  toAccount: number = 0;
  amount: number = 0;
  transferSuccess: boolean = false;
  transferError: string | null = null;

  constructor(private http: HttpClient, private router: Router) {}

  transferMoney() {
    const transferData = {
      fromAccount: { account_id: this.fromAccount },
      toAccount: { account_id: this.toAccount },
      amount: this.amount,
      timestamp: new Date().toISOString(),
      status: "PENDING"
    };

    // Retrieve the JWT token from localStorage
    const token = localStorage.getItem('authToken');
    console.log(token);
    if (token) {
      const headers = new HttpHeaders({
        'Authorization': `Bearer ${token}`
      });
console.log(headers);
      // Make the POST request with the Authorization header
      this.http.post('http://localhost:8080/api/payment/transfer/accountNumber', transferData, { headers, responseType : "text" }).subscribe(
        (response) => {
          console.log('Transfer successful', response);
          this.transferSuccess = true;
          this.transferError = null;
        },
        (error) => {
          console.error('Transfer failed', error);
          this.transferError = error.error || 'Transfer failed due to an unknown error';
          this.transferSuccess = false;
        }
      );
    } else {
      console.error('No JWT token found');
      this.transferError = 'Authentication failed: No JWT token found';
      this.transferSuccess = false;
      // Redirect to the login page if token is missing
      this.router.navigate(['/login']);
    }
  }
}
