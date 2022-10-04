package com.ty.thymeleaf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ty.thymeleaf.model.Book;
import com.ty.thymeleaf.repository.BookRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService {

	private final BookRepository bookRepository;

	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}

	public void deleteBook(Integer id) {
		bookRepository.deleteById(id);
	}

	public Book getBookById(Integer id) {
		Optional<Book> bookDetails = bookRepository.findById(id);
		if (bookDetails.isPresent()) {
			return bookDetails.get();
		}
		return null;
	}

	public Book updateBook(Book book) {
		return bookRepository.save(book);
	}

}
