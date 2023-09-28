package com.example.bookstore.bookstoremanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.bookstore.bookstoremanagement.entity.Books;
import com.example.bookstore.bookstoremanagement.repository.Booksrepository;

@Service
public class booksService {

@Autowired

Booksrepository  booksRepository;

    

    

     @Transactional(readOnly=true)

     public List<Books> getAllBooks(){

          return booksRepository.findAll();


     }

     @Transactional(readOnly=true)

     public Books getBookById(int Book_id) {

    Optional<Books> ct= booksRepository.findById(Book_id);

    if(ct.isPresent())

        return ct.get();

    return null;

     }



	@Transactional

	public List<Books> searchBooksBy(String name) {

		return booksRepository.searchBook(name);

	
	}
	@Transactional

    public boolean insertIntoBooks(Books book) {

      return booksRepository.save(book)!=null;

        

    }


}

