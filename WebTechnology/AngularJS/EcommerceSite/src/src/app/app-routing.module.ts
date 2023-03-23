import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomepageComponent } from './components/homepage/homepage.component';
import { ItemListComponent } from './item-list/item-list.component';
import { UpdateComponent } from './update/update.component';


const routes: Routes = [
  {path: "home",component:HomepageComponent},
  {path: "item",component:ItemListComponent},
  {path: "update",component:UpdateComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
