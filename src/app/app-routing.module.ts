import { NgModule } from '@angular/core';
import { RouterModule, Routes ,} from '@angular/router';
import { AboutusComponent } from './aboutus/aboutus.component';
import { HomeComponent } from './home/home.component';

import { RegisterComponent } from './register/register.component';

const routes: Routes = [
{path:'home',component:HomeComponent},
  {path:"register",component:RegisterComponent},
  {path:"aboutus",component:AboutusComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
