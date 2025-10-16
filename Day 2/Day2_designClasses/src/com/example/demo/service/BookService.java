package com.example.demo.service;

import com.example.demo.Book;

public class BookService {
	
	
	private Book[] books;
	private int size = 0;
	
	public BookService() {
		super();
		this.books = new Book[1];
	}
	
	public void resize() {
		Book[] resizedBooks = new Book[this.books.length * 2];
		int i = 0;
		for(Book book : this.books) {
			resizedBooks[i] = book;
			i++;
		}
		this.books = resizedBooks;
	}
	public boolean addBook(Book book) {
		if(this.size==this.books.length)
			resize();
		this.books[size] = book;
		this.size++;
		return true;
	}
	
	public boolean addAll(Book[] books) {
		for(Book book : books) {
			addBook(book);
		}
		return true;
	}
	
	public Book[] getBooks() {
		Book []list = new Book[size];
		for(int i=0;i<size;i++) {
			list[i] = this.books[i];
		}
		return list;
	}
	
	public int getSize() {
		return this.size;
	}
	
}
