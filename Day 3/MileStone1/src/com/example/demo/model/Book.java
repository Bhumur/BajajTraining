package com.example.demo.model;

import java.util.Objects;

import com.example.demo.exception.RangeCheckException;

public class Book {
	private int bookNumber;
	private String bookName;
	private double ratePerUnit;
	public Book() {
		super();
	}
	public Book(int bookNumber, String bookName, double ratePerUnit) throws RangeCheckException {
		super();
		this.bookNumber = bookNumber;
		this.bookName = bookName;
		if(ratePerUnit <0 || ratePerUnit >99999) {
			throw new RangeCheckException("ERR-101 Rateper unit should be 1 to 99999");
		}
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
	public void setRatePerUnit(double ratePerUnit){
		try {
			if(ratePerUnit <0 || ratePerUnit >99999) {
				throw new RangeCheckException("ERR-101 Rateper unit should be 1 to 99999");
			}
			this.ratePerUnit = ratePerUnit;
		}catch (RangeCheckException e) {
			System.out.println(e.getMessage());
		}
	}
	@Override
	public String toString() {
		return "Book [bookNumber=" + bookNumber + ", bookName=" + bookName + ", ratePerUnit=" + ratePerUnit + "]";
	}
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
