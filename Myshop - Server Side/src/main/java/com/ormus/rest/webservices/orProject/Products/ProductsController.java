package com.ormus.rest.webservices.orProject.Products;

import java.net.URI;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class ProductsController {
	
	@Autowired
	private productServer prodServer;
	
	@GetMapping(path="/products")
	public List<Product> getProducts(){
		return this.prodServer.getAllProducts();
	}
	
	@GetMapping(path="/product/{id}")
	public Product getProduct(@PathVariable long id){
		return this.prodServer.getProductById(id);
	}
	
	@PostMapping(path="/product")
	public ResponseEntity<Product> insertProduct(@RequestBody Product product){
		System.out.println(product.getImageUrl());
		if (this.prodServer.checkExistence(product)) return null;
		this.prodServer.addNewProd(product);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(product.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(path="/product")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product){
		Product updatedProduct = this.prodServer.updateProd(product);
		return new ResponseEntity<>(updatedProduct,HttpStatus.OK);
	}
	
	@PostMapping(path="/product-cart")
	public Key createCart(){
		Key key = new Key(this.prodServer.addCart());
		System.out.println("1 " + key.getuKey());
//		return new ResponseEntity<Key>(key,HttpStatus.OK);
		return key;
	}
	
//	@GetMapping(path="/product-cart/{cartId}")
//	public Cart getCart(@PathVariable Long cardId){
//		return this.prodServer.getCartById(cardId);
//	}
	
	
	@GetMapping(path="/carts")
	public HashMap<String, Cart> getCarts(){
		return this.prodServer.getAllCarts();
	}
	
	@PostMapping(path="/add-item/{cartId}")
	public ResponseEntity<Key> addItem(@PathVariable String cartId,@RequestBody Product product){
//		System.out.println(cartId);
		Key key = new Key(cartId);
//		System.out.println(cartId);
		this.prodServer.addItemToCart(key,product);
		return new ResponseEntity<>(key,HttpStatus.OK);
	}
	
}
