import { Component, OnInit } from '@angular/core';
import { Book } from './book';
import { BookService } from './book.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  books: Book[] = [];
  selectedBook: Book = {
    id: '',
    title: '',
    author: '',
    isbn: '',
    cover: '',
    description: ''
  };
  isCreating: boolean = false;
  isUpdating: boolean = false;

  constructor(private bookService: BookService) { }

  ngOnInit() {
    this.getBooks();
  }

  getBooks(): void {
    this.bookService.getBooks().subscribe(books => this.books = books);
  }

  onSelect(book: Book): void {
    this.selectedBook = book;
  }

  onCreate(): void {
    this.isCreating = true;
    this.selectedBook = {} as Book;
  }

  onEdit(): void {
    this.isUpdating = true;
  }

  onCancel(): void {
    this.selectedBook ={
      id: '',
      title: '',
      author: '',
      isbn: '',
      cover: '',
      description: ''
    };
    this.isCreating = false;
    this.isUpdating = false;
  }

  onSave(book: Book): void {
    if (this.isCreating) {
      this.bookService.createBook(book).subscribe(() => {
        this.getBooks();
        this.onCancel();
      });
    } else if (this.isUpdating) {
      this.bookService.updateBook(book).subscribe(() => {
        this.getBooks();
        this.onCancel();
      });
    }
  }

  onDelete(book: Book): void {
    this.bookService.deleteBook(book.id).subscribe(() => {
      this.books = this.books.filter(b => b.id !== book.id);
      this.onCancel();
    });
  }
}
