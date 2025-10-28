package com.example.demo.service;


import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.example.demo.Day14BookServiceApplication;
import com.example.demo.dtos.BookDto;
import com.example.demo.entity.Book;
import com.example.demo.repo.BookRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class BookService {

    private final Day14BookServiceApplication day14BookServiceApplication;

	private BookRepo repo;
	
	private ModelMapper mapper;

	public BookService(BookRepo repo, ModelMapper mapper, Day14BookServiceApplication day14BookServiceApplication) {
		super();
		this.repo = repo;
		this.mapper = mapper;
		this.day14BookServiceApplication = day14BookServiceApplication;
	}
	
	public BookDto save(BookDto dto) {
		return mapBookToDto(repo.save(mapDtoToBook(dto)));
	}
	
	public List<BookDto> findAll() {
	    return this.repo.findAll()
	            .stream()
	            .map(e -> mapBookToDto(e))
	            .collect(Collectors.toList());
	}
	
	public BookDto findById(int id) {
		return mapBookToDto(this.repo.findById(id).orElseThrow());
	}
	
	public boolean remove(int id) {
		if(this.repo.existsById(id)) {
			this.repo.deleteById(id);
			return true;
		}
		return this.repo.existsById(id);
	}
	
	public BookDto replace(int id, BookDto dto) {
		BookDto result = null;
		if(this.repo.existsById(id)) {
			result = mapBookToDto(this.repo.save(mapDtoToBook(dto)));
		}
		return result;
	}
	
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public BookDto updateStock(int id, int quantity) {
	    BookDto dto = findById(id);
	    if (dto.stockInHand() < quantity)
	        throw new RuntimeException("Not enough stock");

	    int updatedStock = dto.stockInHand() - quantity;
	    int result = repo.updateStock(id, updatedStock);

	    // 🧠 Important: clear persistence context to get fresh data from DB
	    entityManager.clear();

	    if (result > 0) {
	        BookDto updated = findById(id);
	        System.out.println("Before update: " + dto);
	        System.out.println("After update: " + updated);
	        return updated;
	    }

	    throw new RuntimeException("Update failed");
	}



	private Book mapDtoToBook(BookDto dto) {
		return new Book(dto.bookId(),
				dto.bookName(),
				dto.author(),
				dto.isbn(),
				dto.releaseYear(),
				dto.unitPrice(),
				dto.stockInHand());
//		return this.mapper.map(dto, Book.class);
	}
	
	private BookDto mapBookToDto(Book book) {
		return new BookDto(
				book.getBookId(),
				book.getBookName(),
				book.getAuthor(),
				book.getIsbn(),
				book.getReleaseYear(),
				book.getUnitPrice(),
				book.getStockInHand());
//		return this.mapper.map(book, BookDto.class);
	}
	
}
