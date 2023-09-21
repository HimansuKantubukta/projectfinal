package com.example.bookstore.bookstoremanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.bookstore.bookstoremanagement.entity.Orderitems;



public interface OrderItemsRepository  extends JpaRepository<Orderitems,Integer>
{
//	@Query("SELECT i FROM Orderitems i WHERE i.customerId = :customerid")
//    List<Orderitems> showAllOrderItems(@Param("customerid") int customerId);

	List<Orderitems> findByCustomerId(int customerId);
}
