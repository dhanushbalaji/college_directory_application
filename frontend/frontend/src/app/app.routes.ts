import { Routes } from '@angular/router';
import { LoginComponent } from './auth/login/login.component';
import { AdminComponent } from './admin/admin.component';
import { StudentComponent } from './student/student.component';
import { FacultyComponent } from './faculty/faculty.component';

export const routes: Routes = [
    { path: '', redirectTo: 'login', pathMatch: 'full' },
    { path: 'login', component: LoginComponent },
    { path: 'admin', component: AdminComponent },
    { path: 'student', component: StudentComponent },
    { path: 'faculty', component: FacultyComponent },
    { path: '**', redirectTo: 'login' }
];
