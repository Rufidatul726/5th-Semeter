import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { CreatebookComponent } from './createbook/createbook.component';
import { ShowBookListComponent } from './show-book-list/show-book-list.component';
import { BookCardComponent } from './book-card/book-card.component';
import { ShowBookDetailsComponent } from './show-book-details/show-book-details.component';
import { UpdateBookInfoComponent } from './update-book-info/update-book-info.component';
import { SearchBookListComponent } from './search-book-list/search-book-list.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    CreatebookComponent,
    ShowBookListComponent,
    BookCardComponent,
    ShowBookDetailsComponent,
    UpdateBookInfoComponent,
    SearchBookListComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
