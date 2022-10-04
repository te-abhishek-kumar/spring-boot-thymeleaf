package com.ty.thymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ty.thymeleaf.model.Book;
import com.ty.thymeleaf.service.BookService;
import com.ty.thymeleaf.util.AppConstant;

@Controller
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping("/get-all-books")
	public String getBookDetails(Model model) {
		model.addAttribute("books", bookService.getAllBooks());
		return "books";
	}

	@GetMapping("/add-book-form")
	public String addBookForm(Model model) {
		Book book = new Book();
		model.addAttribute("addBook", book);
		return "add_book";
	}

	@PostMapping("/add-book")
	public String saveBook(@ModelAttribute("book") Book book) {
		bookService.saveBook(book);
		return AppConstant.HOME_PATH;
	}

	@GetMapping("/update-book-form/{id}")
	public String updateBookForm(@PathVariable Integer id, Model model) {
		model.addAttribute("book", bookService.getBookById(id));
		return "update_book";
	}

	@PostMapping("/update-book/{id}")
	public String updateBook(@PathVariable Integer id, @ModelAttribute("book") Book book) {
		Book optional = bookService.getBookById(id);
		optional.setName(book.getName());
		optional.setAuthor(book.getAuthor());
		bookService.updateBook(book);
		return AppConstant.HOME_PATH;
	}

	@GetMapping("/delete-book/{id}")
	public String deleteBook(@PathVariable Integer id) {
		bookService.deleteBook(id);
		return AppConstant.HOME_PATH;
	}

}
