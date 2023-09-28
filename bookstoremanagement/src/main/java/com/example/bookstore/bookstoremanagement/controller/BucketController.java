package com.example.bookstore.bookstoremanagement.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstore.bookstoremanagement.entity.Bucket;
import com.example.bookstore.bookstoremanagement.entity.Customers;
import com.example.bookstore.bookstoremanagement.repository.BucketRepository;
import com.example.bookstore.bookstoremanagement.service.BucketService;

import jakarta.servlet.http.HttpSession;

@CrossOrigin(origins= {"http://localhost:4200"},allowCredentials = "true")
@RequestMapping("/bucket")
@RestController
public class BucketController
{
	@Autowired
	BucketService bucketService;
	
	@Autowired
	BucketRepository bucketRepository;

	@GetMapping(value="/all",produces="application/json")
	 public ResponseEntity<List<Bucket>>getalldetails(HttpSession session)
	 {
		if(session.getAttribute("customerId")!= null)
		{
		  List<Bucket> t1= bucketRepository.getBucketByCustomerID(Integer.parseInt(session.getAttribute("customerId").toString()));

		  if(t1.size()!=0) {

			  return  ResponseEntity.ok(t1);}
		 
		  
		}
		
			 return ResponseEntity.notFound().build();
		  

	 }

	@PostMapping(value="/order", consumes="application/json")
	public HttpStatus insertCart(@RequestBody Bucket cart, HttpSession session)//
	{
		System.out.println(session.getAttribute("customerId"));
		if(session.getAttribute("customerId")!= null) {
			Customers cust = new Customers();
			cust.setCustomer_id((int)session.getAttribute("customerId"));
			cart.setCustomer_id(cust);
			cart.setBook_id(cart.getBook_id());
			cart.setQuantity(1);
			bucketService.insertorModify(cart);
			return HttpStatus.OK;
		}
		return HttpStatus.NOT_MODIFIED;
	}


	 @PutMapping(value="/",consumes="applications/json")
	 public HttpStatus ModifyBucket(@RequestBody Bucket bucket) {
		 if(bucketService.insertorModify(bucket))
			 return HttpStatus.OK;
		 return HttpStatus.NOT_MODIFIED;
	}


	 @DeleteMapping("/{bucketId}")
	 public HttpStatus deleteBucket(@PathVariable int bucketId)
	 {
		 if(bucketService.deleteByid(bucketId))
			 return HttpStatus.OK;
		 return HttpStatus.NOT_FOUND;
	 }
	 
	 @PostMapping("/increasequantity")
	 public HttpStatus increasequantity(@RequestBody Bucket bucket,HttpSession session)
	 {
		 if(session.getAttribute("customerId")!= null)
		 {
		  bucketRepository.increasequantity(bucket.getBucketId());
		  return HttpStatus.OK;
		 }
		 return HttpStatus.NOT_FOUND;
	 }
	 @PostMapping("decreasequantity")
	 public HttpStatus decreasequantity(@RequestBody Bucket bucket,HttpSession session)
	 {
		 if(session.getAttribute("customerId")!= null)
		 {
		  bucketRepository.decreasequantity(bucket.getBucketId());
		  return HttpStatus.OK;
		 }
		 return HttpStatus.NOT_FOUND;
	 }
	 
	 @GetMapping("/makepayment")
	 public HttpStatus makepayment(HttpSession session)
	 {
		 if(session.getAttribute("customerId")!= null)
		 {
			 long count = bucketRepository.count();
			 bucketService.makepayment((int)session.getAttribute("customerId"));
			 
			 if(count != bucketRepository.count()) {
				 return HttpStatus.OK;
			 }
			 else {
				 return HttpStatus.NOT_MODIFIED;
			 }
			 
			 
		 }
		 return HttpStatus.NOT_FOUND;
		
	 }
}
	 