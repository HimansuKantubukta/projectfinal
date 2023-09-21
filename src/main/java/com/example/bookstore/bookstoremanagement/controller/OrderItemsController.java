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

import com.example.bookstore.bookstoremanagement.entity.Orderitems;
import com.example.bookstore.bookstoremanagement.repository.OrderItemsRepository;
import com.example.bookstore.bookstoremanagement.service.OrderItemsService;

import jakarta.servlet.http.HttpSession;

@CrossOrigin(origins= {"http://localhost:4200"},allowCredentials = "true")
@RequestMapping("/Orderitems")
@RestController
public class OrderItemsController
{
	@Autowired
	OrderItemsService itemService;
	
	@Autowired
	OrderItemsRepository  oi;

	@GetMapping(value="/",produces="application/json")
	 public ResponseEntity<List<Orderitems>>getallitems()
	 {
		  List<Orderitems> t1=itemService.getallitems();
		  if(t1.size()!=0)
			return new ResponseEntity<List<Orderitems>>(t1,HttpStatus.OK);
			  return new ResponseEntity<List<Orderitems>>(t1,HttpStatus.NOT_FOUND);

	 }


 

	 @PostMapping(value="/",consumes="applications/json")
	 public HttpStatus insertOrder_items(@RequestBody Orderitems order) {
		 if(itemService.insertorModify(order))
			 return HttpStatus.OK;
		 return HttpStatus.NOT_MODIFIED;
	}


	 @PutMapping(value="/",consumes="applications/json")
	 public HttpStatus ModifyOrder_items(@RequestBody Orderitems order) {
		 if(itemService.insertorModify(order))
			 return HttpStatus.OK;
		 return HttpStatus.NOT_MODIFIED;
	}


	 @DeleteMapping("/{customerId}")
	 public HttpStatus deleteOrder_items(@PathVariable int Id)
	 {
		 if(itemService.deleteByid(Id))
			 return HttpStatus.OK;
		 return HttpStatus.NOT_FOUND;
	 }
	 
	 @GetMapping("/allorderitems")
	 public List<Orderitems> getAllOrderItems(HttpSession session)
	 {
		 if(session.getAttribute("customerId")!=null)
		 {
			 int customerid=(int)session.getAttribute("customerId");
			  return oi.findByCustomerId(customerid);
			
			 
			 
		 }
		 return null;
	 }
}