package com.example.demo.dtos;


public record BookDto(

        int bookId,

        String bookName,

        String author,

        String isbn,

        int releaseYear,

        double unitPrice,

        int stockInHand
) {
	
}
