package com.example.bookstore.bookstoremanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.bookstore.bookstoremanagement.entity.Bucket;
import com.example.bookstore.bookstoremanagement.entity.Customers;
@Repository
public interface BucketRepository extends JpaRepository<Bucket,Integer>
{
		

@Query(nativeQuery = true, value = "select * from bucket where cust_id=:customer_id")
public List<Bucket> getBucketByCustomerID(@Param("customer_id") int customer_id );


  @Procedure("increasequantity")
  void increasequantity(@Param("bucket_id") int bucketId);
  
  @Procedure("decreasequantity")
  void decreasequantity(@Param("bucket_id") int bucketId);
  
  @Procedure("makepayment")
  void makepayment(@Param("customerId") int customerId);
 
}
