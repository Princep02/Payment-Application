import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = 'http://localhost:8080/api/payment';

  constructor(private http: HttpClient) {}

  login(phoneNumber: string, password: string): Observable<any> {
    return this.http.post(`${this.apiUrl}/users/login`, { phonenumber: phoneNumber, password });
  }

  signup(phoneNumber: string, password: string): Observable<any> {
    return this.http.post(`${this.apiUrl}/users/signup`, { phonenumber: phoneNumber, password });
  }
  // Method to logout
  logout(): void {
    localStorage.removeItem('token');
  }
}