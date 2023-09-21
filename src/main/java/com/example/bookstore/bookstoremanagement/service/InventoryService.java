package com.example.bookstore.bookstoremanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.bookstore.bookstoremanagement.entity.Inventory;
import com.example.bookstore.bookstoremanagement.repository.InventoryRepository;


@Service
public class InventoryService
{
	@Autowired
	InventoryRepository inventoryrepository;
	
	@Transactional(readOnly=true)

    public List<Inventory> getAllinventories(){

         return inventoryrepository.findAll();

    

    }

   

    

     @Transactional

     public boolean insertIntoinventory(Inventory cust) {

       return inventoryrepository.save(cust)!=null;

         

     }

     

  

}

