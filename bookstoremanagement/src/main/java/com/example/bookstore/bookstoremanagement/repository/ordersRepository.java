package com.example.bookstore.bookstoremanagement.repository;



import org.springframework.data.jpa.repository.JpaRepository;


import com.example.bookstore.bookstoremanagement.entity.Orders;

public interface ordersRepository extends JpaRepository<Orders,Integer>{



}
