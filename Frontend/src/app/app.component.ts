import { Component } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';  // Import routing related modules
import { RouterOutlet } from '@angular/router';  // For displaying routed components
import { SignupComponent } from './signup/signup.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { HeaderComponent } from './header/header.component';
import { TransferComponent } from './transfer/transfer.component';

const routes: Routes = [
  { path: '', component: SignupComponent },  // Default route
  { path: 'login', component: LoginComponent },  // Login page route
  { path: 'home', component: HomeComponent },  // Home page route
  { path: 'transfer', component: TransferComponent } // Fixed the syntax error here
];

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterModule, RouterOutlet, SignupComponent, LoginComponent, HomeComponent, HeaderComponent, TransferComponent],  // Import necessary modules and components
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'project';
}
