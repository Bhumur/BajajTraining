package com.example.demo;

import java.util.Objects;

public class Book {
	private int bookNumber;
	private String bookName;
	private double ratePerUnit;
	
	public Book() {
		super();
	}
	public Book(int bookNumber, String bookName, double ratePerUnit) {
		super();
		this.bookNumber = bookNumber;
		this.bookName = bookName;
		this.ratePerUnit = ratePerUnit;
	}
	
	public int getBookNumber() {
		return bookNumber;
	}
	public void setBookNumber(int bookNumber) {
		this.bookNumber = bookNumber;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public double getRatePerUnit() {
		return ratePerUnit;
	}
	public void setRatePerUnit(double ratePerUnit) {
		this.ratePerUnit = ratePerUnit;
	}
	
	@Override
	public String toString() {
		return "Book [bookNumber=" + bookNumber + ", bookName=" + bookName + ", ratePerUnit=" + ratePerUnit + "]";
	}
//	@Override
//	public boolean equals(Object obj) {
//		Book book = (Book)obj;
//		return this.bookName.equals(book.getBookName()) &&
//				this.bookNumber==book.bookNumber &&
//				this.ratePerUnit==book.ratePerUnit;
//	}
	@Override
	public int hashCode() {
		return Objects.hash(bookName, bookNumber, ratePerUnit);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(bookName, other.bookName) && bookNumber == other.bookNumber
				&& Double.doubleToLongBits(ratePerUnit) == Double.doubleToLongBits(other.ratePerUnit);
	}
	
	
	
	
}
