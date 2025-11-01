package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Book;
import java.util.List;


public interface BookRepo extends JpaRepository<Book, Integer> {

	@Modifying
	@Transactional
	@Query("UPDATE Book b SET b.stockInHand = :updatedStock WHERE b.bookId = :id")
	int updateStock(int id, int updatedStock);
	
	Book findByBookName(String bookName);

}
