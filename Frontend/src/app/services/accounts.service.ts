import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AccountService {
  private baseUrl = 'http://localhost:8080/api/payment';

  constructor(private http: HttpClient) {}

  getUserAccounts(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/accounts`);
  }

  getTransactionHistory(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/transactions`);
  }

  getAccountsByPhoneNumber(phoneNumber: string): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/byPhone/${phoneNumber}`);
  }
  
  transferMoney(transferData: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/transfer/accountNumber`, transferData);
  }
}
