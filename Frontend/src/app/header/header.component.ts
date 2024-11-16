import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  standalone:true,
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {
  constructor(private router: Router) {}

  navigateToSignup() {
    this.router.navigate(['/signup']);
  }

  navigateToLogin() {
    this.router.navigate(['/login']);
  }
}
