package com.example.bookstore.bookstoremanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookstore.bookstoremanagement.entity.Orderitems;



public interface OrderItemsRepository  extends JpaRepository<Orderitems,Integer>
{


	List<Orderitems> findByCustomerId(int customerId);
}
