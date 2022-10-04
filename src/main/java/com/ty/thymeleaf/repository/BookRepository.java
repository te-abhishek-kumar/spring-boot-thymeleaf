package com.ty.thymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.thymeleaf.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
