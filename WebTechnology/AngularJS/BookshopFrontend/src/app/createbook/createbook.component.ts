import { Component } from '@angular/core';
import { BookService } from '../book.service';
import { Book } from '../book';

@Component({
  selector: 'app-createbook',
  templateUrl: './createbook.component.html',
  styleUrls: ['./createbook.component.css']
})
export class CreatebookComponent {
  book: Book = {
    title: '',
    author: '',
    isbn: '',
    cover: '',
    id: '',
    description: ''
  };

  constructor(private bookService: BookService) { }

  onSave(book: Book): void {
    this.bookService.createBook(book).subscribe(() => {
      this.book = {} as Book;
    });
  }
}
  


