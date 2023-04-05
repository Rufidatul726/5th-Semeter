import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreatebookComponent } from './createbook/createbook.component';
import { ShowBookListComponent } from './show-book-list/show-book-list.component';
import { ShowBookDetailsComponent } from './show-book-details/show-book-details.component';
import { UpdateBookInfoComponent } from './update-book-info/update-book-info.component';

const routes: Routes = [
  // { path: '', redirectTo: 'books', pathMatch: 'full' },

  { path: '', component: ShowBookListComponent },
  { path: 'create', component: CreatebookComponent },
  { path: ':id', component: ShowBookDetailsComponent },
  { path: ':id/edit', component: UpdateBookInfoComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
