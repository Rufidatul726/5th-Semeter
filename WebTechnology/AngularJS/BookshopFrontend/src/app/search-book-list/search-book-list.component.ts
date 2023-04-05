import { Component, OnInit } from '@angular/core';
import { Book } from '../book';
import { BookService } from '../book.service';

@Component({
  selector: 'app-search-book-list',
  templateUrl: './search-book-list.component.html',
  styleUrls: ['./search-book-list.component.css']
})
export class SearchBookListComponent implements OnInit {
  books: Book[] = [];
  filteredBooks: Book[] = [];
  searchTerm: string = '';

  constructor(private bookService: BookService) { }

  ngOnInit(): void {
    this.bookService.getBooks().subscribe((books) => {
      this.books = books;
      this.filteredBooks = books;
    });
  }

  search(): void {
    this.filteredBooks = this.books.filter((book) => {
      return book.title.toLowerCase().includes(this.searchTerm.toLowerCase());
    });
  }
}
