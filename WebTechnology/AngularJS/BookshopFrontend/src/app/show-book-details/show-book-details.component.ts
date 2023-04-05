import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BookService } from '../book.service';
import { Book } from '../book';

@Component({
  selector: 'app-show-book-details',
  templateUrl: './show-book-details.component.html',
  styleUrls: ['./show-book-details.component.css']
})

export class ShowBookDetailsComponent implements OnInit{
  book: Book;

  constructor(private route: ActivatedRoute, private bookService: BookService) { }

  ngOnInit() {
    const id = this.route.snapshot.paramMap.get('id');
    this.bookService.getBook(id).subscribe((book) => {
      this.book = book;
    });
  }
}