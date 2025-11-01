package com.example.demo.dto;

public class CatalogDto {
	
	private BookDto book;
	private ReviewDto review;
	public CatalogDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CatalogDto(BookDto book, ReviewDto review) {
		super();
		this.book = book;
		this.review = review;
	}
	public BookDto getBook() {
		return book;
	}
	public void setBook(BookDto book) {
		this.book = book;
	}
	public ReviewDto getReview() {
		return review;
	}
	public void setReview(ReviewDto review) {
		this.review = review;
	}
	@Override
	public String toString() {
		return "CatalogDto [book=" + book + ", review=" + review + "]";
	}
	
	

}
