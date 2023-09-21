package com.example.bookstore.bookstoremanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.bookstore.bookstoremanagement.entity.Orderitems;
import com.example.bookstore.bookstoremanagement.repository.OrderItemsRepository;

@Service

public class OrderItemsService {

@Autowired

OrderItemsRepository orderitemsrepository;

@Transactional

public List<Orderitems> getallitems(){

    return orderitemsrepository.findAll();

}


@Transactional(readOnly=true)

  public Orderitems getByid(int order_id) {

    Optional<Orderitems> ot=orderitemsrepository.findById(order_id);

    if(ot.isPresent())

        return ot.get();

    return null;

}

@Transactional

public boolean insertorModify(Orderitems order) {

    return orderitemsrepository.save(order)!=null;


}

@Transactional

public boolean  deleteByid(int id) {

     long count=orderitemsrepository.count();

     orderitemsrepository.deleteById(id);

    return count> orderitemsrepository.count();

}

 

}
