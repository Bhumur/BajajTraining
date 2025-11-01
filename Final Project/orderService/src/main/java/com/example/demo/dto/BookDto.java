package com.example.demo.dto;

public record BookDto(

        int bookId,

        String bookName,

        String author,

        String isbn,

        int releaseYear,

        double unitPrice,

        int stockInHand
) {
	public BookDto() {
		this(0,null,null,null,0,0.0,0);
	}
}
