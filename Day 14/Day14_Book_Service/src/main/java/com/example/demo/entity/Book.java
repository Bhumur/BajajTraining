package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Book {

	@Id
	private int bookId;
	private String bookName;
	private String author;
	private String isbn;
	private int releaseYear;
	private double unitPrice;
	private int stockInHand;
	public Book(int bookId, String bookName, String author, String isbn, int releaseYear, double unitPrice,
			int stockInHand) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.author = author;
		this.isbn = isbn;
		this.releaseYear = releaseYear;
		this.unitPrice = unitPrice;
		this.stockInHand = stockInHand;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", author=" + author + ", isbn=" + isbn
				+ ", releaseYear=" + releaseYear + ", unitPrice=" + unitPrice + ", stockInHand=" + stockInHand + "]";
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getStockInHand() {
		return stockInHand;
	}
	public void setStockInHand(int stockInHand) {
		this.stockInHand = stockInHand;
	}
	
	
}
