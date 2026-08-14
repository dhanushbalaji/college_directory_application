import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth.services';
import { loginPageOptions } from './options';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
  loginForm: FormGroup;
  isSubmitting = false;
  errorMessage = '';

  pageOptions = loginPageOptions;

  constructor(
    private fb: FormBuilder,
    private authService: AuthService,
    private router: Router
  ) {
    this.loginForm = this.fb.group({
      username: ['', Validators.required],
      password: ['', Validators.required],
      role: ['STUDENT', Validators.required]
    });
  }

  onSubmit(): void {
    if (this.loginForm.invalid) {
      this.loginForm.markAllAsTouched();
      return;
    }

    this.isSubmitting = true;
    this.errorMessage = '';

    const { username, password, role } = this.loginForm.value;

    this.authService.login(username, password, role).subscribe({
      next: (res) => {
        localStorage.setItem('token', res.token);
        localStorage.setItem('username', res.username);
        localStorage.setItem('role', res.role);

        if (res.role === 'ADMINISTRATOR') {
          this.router.navigate(['/admin']);
        } else if (res.role === 'FACULTY_MEMBER') {
          this.router.navigate(['/faculty']);
        } else {
          this.router.navigate(['/student']);
        }
      },
      error: (err) => {
        this.errorMessage = err.error?.error || 'Login failed';
        this.isSubmitting = false;
      },
      complete: () => {
        this.isSubmitting = false;
      }
    });
  }
}