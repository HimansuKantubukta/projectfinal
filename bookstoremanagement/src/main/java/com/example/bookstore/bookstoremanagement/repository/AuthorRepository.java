package com.example.bookstore.bookstoremanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookstore.bookstoremanagement.entity.Author;








public interface AuthorRepository extends JpaRepository<Author,Integer>
{

}
