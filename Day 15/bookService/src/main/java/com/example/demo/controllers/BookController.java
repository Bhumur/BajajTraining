package com.example.demo.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.dtos.BookDto;
import com.example.demo.service.BookService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    // ✅ GET all books
    @GetMapping
    @Operation(
        summary = "Get all books",
        description = "Retrieve the details of all book resources",
        parameters = @Parameter(required = false)
    )
    public List<BookDto> findAll() {
        return this.service.findAll();
    }

    // ✅ GET by ID
    @GetMapping("/{id}")
    @Operation(
        summary = "Get book by ID",
        description = "Retrieve book resource by its ID",
        parameters = @Parameter(required = true, example = "1")
    )
    public BookDto findById(@PathVariable int id) {
        return this.service.findById(id);
    }

    // ✅ POST (Create)
    @PostMapping("/save")
    @Operation(
        summary = "Create a new book",
        description = "Add a new book resource and return it with location header"
    )
    public ResponseEntity<BookDto> save(@Valid @RequestBody BookDto dto) {
        System.out.println("-------------------------------------------------------------------------------");
        BookDto saved = this.service.save(dto);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saved.bookId())   // works fine for record-based DTO
                .toUri();

        return ResponseEntity.created(location).body(saved);
    }

    // ✅ DELETE by ID
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete book by ID")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
    	
        if (this.service.remove(id)) {
            return ResponseEntity.noContent().build();
        }
        System.out.println("0000000000000000000000000000000000000000000000000000000000000000000000000");
        return ResponseEntity.notFound().build();
    }

    // ✅ PUT (Update)
    @PutMapping("/{id}")
    @Operation(summary = "Update book by ID")
    public ResponseEntity<BookDto> update(@PathVariable int id, 
                                          @Valid @org.springframework.web.bind.annotation.RequestBody BookDto dto) {
        BookDto updated = this.service.replace(id, dto);
        return ResponseEntity.ok(updated);
    }
    
    @PatchMapping("/{id}")
    @Operation(summary = "Update Book Stock by ID")
    public ResponseEntity<BookDto> updateStock(@PathVariable int id, 
                                          @RequestParam  int qty) {
        BookDto updated = this.service.updateStock(id, qty);
        if(updated!=null)
        	ResponseEntity.badRequest();
        return ResponseEntity.ok(updated);
    }
}
