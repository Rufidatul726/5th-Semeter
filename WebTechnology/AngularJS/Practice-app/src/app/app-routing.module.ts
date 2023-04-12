import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { Component1Component } from './component1/component1.component';
import { AddnewproductComponent } from './addnewproduct/addnewproduct.component'

const routes: Routes = [
  { path: '', component: Component1Component },
  {path: 'addProduct', component: AddnewproductComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
