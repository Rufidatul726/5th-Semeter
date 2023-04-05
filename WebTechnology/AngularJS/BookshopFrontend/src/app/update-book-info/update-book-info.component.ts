import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { NgModel } from '@angular/forms';
import { BookService } from '../book.service';
import { Book } from '../book';

@Component({
  selector: 'app-update-book-info',
  templateUrl: './update-book-info.component.html',
  styleUrls: ['./update-book-info.component.css']
})
export class UpdateBookInfoComponent {
  book: Book = {
    id: '',
    title: '',
    author: '',
    isbn: '',
    cover: '',
    description: ''
  };

  constructor(private route: ActivatedRoute, private router: Router, private bookService: BookService) { }

  ngOnInit() {
    const id = this.route.snapshot.paramMap.get('id');
    console.log(id);
    // this.bookService.getBook(id).subscribe((book) => {
    //   this.book = book;
    // });
  }

  onSubmit() {
    this.bookService.updateBook(this.book).subscribe(() => {
      alert('Book updated successfully!');
      this.router.navigate(['/books', this.book.id]);
    });
  }
}
