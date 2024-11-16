import { Routes } from '@angular/router';
import { SignupComponent } from './signup/signup.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { TransferComponent } from './transfer/transfer.component';

// Define the routes here
export const routes: Routes = [
  { path: 'signup', component: SignupComponent },
  { path: 'login', component: LoginComponent },
  { path: 'login/home', component: HomeComponent },
  {path:  'transfer',component:TransferComponent},
  { path: '', redirectTo: '/signup', pathMatch: 'full' }  // Redirect to signup by default
];

