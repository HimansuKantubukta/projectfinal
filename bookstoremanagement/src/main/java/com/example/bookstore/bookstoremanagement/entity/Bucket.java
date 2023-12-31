package com.example.bookstore.bookstoremanagement.entity;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;

import jakarta.persistence.GenerationType;

import jakarta.persistence.Id;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity

@Table(name="bucket")
public class Bucket

{

    

    

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="bucket_id")
    private int bucketId;

     @ManyToOne
     @JoinColumn(name="book_id")
     private Books bookId;

    @ManyToOne()
    @JoinColumn(name="cust_id")
    private Customers customerId;

    @Column(name="price")
    private int bookprice;

    @Column(name="quantity")
    private int quantity;

 

    public Bucket() {}



	public Bucket(int bucketId, Books book_id, Customers customer_id, int bookprice, int quantity) {
		
		this.bucketId = bucketId;
		this.bookId = book_id;
		this.customerId = customer_id;
		this.bookprice = bookprice;
		this.quantity = quantity;
	}



	public int getBucketId() {
		return bucketId;
	}



	public void setBucketId(int bucketId) {
		this.bucketId = bucketId;
	}



	public Books getBook_id() {
		return bookId;
	}



	public void setBook_id(Books book_id) {
		this.bookId = book_id;
	}



	public Customers getCustomer_id() {
		return customerId;
	}



	public void setCustomer_id(Customers customer_id) {
		this.customerId = customer_id;
	}



	public int getBookprice() {
		return bookprice;
	}



	public void setBookprice(int bookprice) {
		this.bookprice = bookprice;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	

 

   

}