import { Component, OnInit } from '@angular/core';
import { BookService } from '../book.service';
import { Book } from '../book';

@Component({
  selector: 'app-show-book-list',
  templateUrl: './show-book-list.component.html',
  styleUrls: ['./show-book-list.component.css']
})

export class ShowBookListComponent implements OnInit{
  books: Book[] = [];

  constructor(private bookService: BookService) { }

  ngOnInit() {
    this.bookService.getBooks().subscribe((books) => {
      this.books = books;
    });
  }
}
