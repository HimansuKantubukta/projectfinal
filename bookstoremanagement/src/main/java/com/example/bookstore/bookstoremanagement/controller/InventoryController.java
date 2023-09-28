package com.example.bookstore.bookstoremanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstore.bookstoremanagement.entity.Inventory;
import com.example.bookstore.bookstoremanagement.repository.InventoryRepository;
import com.example.bookstore.bookstoremanagement.service.InventoryService;


   @CrossOrigin(origins = {"http://localhost:4200"},allowCredentials="true")
   @RequestMapping("/invent")
   @RestController
	public class InventoryController {
		
	    @Autowired
		private InventoryService inventoryService;
	    
	    @Autowired
	    InventoryRepository inventoryrepo;
		
	    @GetMapping(value="/all",produces="application/json")
		 public ResponseEntity<List<Inventory>>getallitems()
		 {
			  List<Inventory> t1=inventoryService.getAllinventories();
			  if(t1.size()!=0)
				return new ResponseEntity<List<Inventory>>(t1,HttpStatus.OK);
				  return new ResponseEntity<List<Inventory>>(t1,HttpStatus.NOT_FOUND);

		 }


	 

		 @PostMapping(value="/",consumes="applications/json")
		 public HttpStatus insertOrder_items(@RequestBody Inventory inventory) {
			 if(inventoryService.insertIntoinventory(inventory))
				 return HttpStatus.OK;
			 return HttpStatus.NOT_MODIFIED;
		}


		 @PutMapping(value="/",consumes="applications/json")
		 public HttpStatus ModifyOrder_items(@RequestBody Inventory inventory) {
			 if(inventoryService.insertIntoinventory(inventory))
				 return HttpStatus.OK;
			 return HttpStatus.NOT_MODIFIED;
		}


		

		
		
		
		
		
	}

