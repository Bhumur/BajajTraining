package com.example.demo.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record BookDto(

        int bookId,

        @NotEmpty(message = "Book Name should not be blank")
        @Size(max = 100, message = "Book name must be less than 100 characters")
        String bookName,

        @NotEmpty(message = "Author name should not be blank")
        String author,

        @NotEmpty(message = "ISBN should not be blank")
        String isbn,

        @Positive(message = "Year of Publication should be a positive number")
        int releaseYear,

        @Max(value = 2000, message = "Unit price cannot exceed 2000")
        double unitPrice,

        @Min(value = 10, message = "Stock must be at least 10")
        @Max(value = 100, message = "Stock cannot exceed 100")
        int stockInHand
) {
	public BookDto() {
		this(0,null,null,null,0,0.0,0);
	}
}
