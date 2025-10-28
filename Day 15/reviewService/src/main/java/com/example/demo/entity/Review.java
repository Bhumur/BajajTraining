package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Review {
	@Id
	private int id;
	private String bookName;
	private String reviewer;
	private int rating;
	public Review(int id, String bookName, String reviewer, int rating) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.reviewer = reviewer;
		this.rating = rating;
	}
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Review [id=" + id + ", bookName=" + bookName + ", reviewer=" + reviewer + ", rating=" + rating + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getReviewer() {
		return reviewer;
	}
	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	
}
