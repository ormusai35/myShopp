package com.ormus.rest.webservices.orProject.Products;

import java.nio.charset.Charset;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class productServer {
	
	private static long counter = 0;
	private static long cart_counter = 0;
	private static List<Product> products = new ArrayList<>(); 
	private HashMap<String, Cart> shoppingCarts = new HashMap<>();
	
	static {
		products.add(new Product(++counter,"nike blue shirt",15.90,"T-shirt","https://www.ubexpress.pk/wp-content/uploads/2019/05/Royal-Blue-Nike-T-Shirt-AA-13.jpg"));
		products.add(new Product(++counter,"mania skinny jeans",99.90,"Pants","https://xcdn.next.co.uk/COMMON/Items/Default/Default/ItemImages/SearchAlt/224x336/530205.jpg"));
		products.add(new Product(++counter,"nike blue shirt",15.90,"T-shirt","https://www.ubexpress.pk/wp-content/uploads/2019/05/Royal-Blue-Nike-T-Shirt-AA-13.jpg"));
		products.add(new Product(++counter,"mania skinny jeans",99.90,"Pants","https://xcdn.next.co.uk/COMMON/Items/Default/Default/ItemImages/SearchAlt/224x336/530205.jpg"));
		products.add(new Product(++counter,"nike blue shirt",15.90,"T-shirt","https://www.ubexpress.pk/wp-content/uploads/2019/05/Royal-Blue-Nike-T-Shirt-AA-13.jpg"));
		products.add(new Product(++counter,"mania skinny jeans",99.90,"Pants","https://xcdn.next.co.uk/COMMON/Items/Default/Default/ItemImages/SearchAlt/224x336/530205.jpg"));
		products.add(new Product(++counter,"nike blue shirt",15.90,"T-shirt","https://www.ubexpress.pk/wp-content/uploads/2019/05/Royal-Blue-Nike-T-Shirt-AA-13.jpg"));
		products.add(new Product(++counter,"mania skinny jeans",99.90,"Pants","https://xcdn.next.co.uk/COMMON/Items/Default/Default/ItemImages/SearchAlt/224x336/530205.jpg"));
		products.add(new Product(++counter,"nike blue shirt",15.90,"T-shirt","https://www.ubexpress.pk/wp-content/uploads/2019/05/Royal-Blue-Nike-T-Shirt-AA-13.jpg"));
		products.add(new Product(++counter,"mania skinny jeans",99.90,"Pants","https://xcdn.next.co.uk/COMMON/Items/Default/Default/ItemImages/SearchAlt/224x336/530205.jpg"));
		products.add(new Product(++counter,"nike blue shirt",15.90,"T-shirt","https://www.ubexpress.pk/wp-content/uploads/2019/05/Royal-Blue-Nike-T-Shirt-AA-13.jpg"));
		products.add(new Product(++counter,"mania skinny jeans",99.90,"Pants","https://xcdn.next.co.uk/COMMON/Items/Default/Default/ItemImages/SearchAlt/224x336/530205.jpg"));
		products.add(new Product(++counter,"nike blue shirt",15.90,"T-shirt","https://www.ubexpress.pk/wp-content/uploads/2019/05/Royal-Blue-Nike-T-Shirt-AA-13.jpg"));
		products.add(new Product(++counter,"mania skinny jeans",99.90,"Pants","https://xcdn.next.co.uk/COMMON/Items/Default/Default/ItemImages/SearchAlt/224x336/530205.jpg"));
		products.add(new Product(++counter,"nike blue shirt",15.90,"T-shirt","https://www.ubexpress.pk/wp-content/uploads/2019/05/Royal-Blue-Nike-T-Shirt-AA-13.jpg"));
		products.add(new Product(++counter,"mania skinny jeans",99.90,"Pants","https://xcdn.next.co.uk/COMMON/Items/Default/Default/ItemImages/SearchAlt/224x336/530205.jpg"));
		products.add(new Product(++counter,"mania skinny jeans",99.90,"Pants","https://xcdn.next.co.uk/COMMON/Items/Default/Default/ItemImages/SearchAlt/224x336/530205.jpg"));
	}

	public List<Product> getAllProducts(){
		return this.products;
	}
	
	public boolean checkExistence(Product prod) {
		for (Product product:products) {
			if (product.compareTo(prod) == 0) return true;
		}
		return false;
	}
	
	public void addNewProd(Product product) {
		if (product.getId() == 0) {
			product.setId(++counter);
			products.add(product);
		}
		
	}

	public Product getProductById(long id) {
		for (Product prod:products) {
			if (prod.getId() == id) return prod;
		}
		return null;
	}

	public Product updateProd(Product product) {
		for(Product prod:products) {
			System.out.println(product.getId());
			if(prod.getId() == product.getId()) {
				if (prod.compareTo(product) != 0) {
					products.remove(prod);
					products.add(product);
					return product;
				}
			}
		}
		return null;
	}
	
	public String addCart() {
//		String random_key = this.getRandomKey();
		String random_key = "dsfdsgfsgasfg";
		shoppingCarts.put(random_key,new Cart(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date(System.currentTimeMillis()))));
		return random_key;
	}
	
	
	public String getRandomKey() {
	    int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 10;
	    Random random = new Random();
	 
	    String generatedString = random.ints(leftLimit, rightLimit + 1)
	      .limit(targetStringLength)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();
	 
	    return generatedString;
	}
	
	public HashMap<String, Cart> getAllCarts(){
		return this.shoppingCarts;
	}

	public Cart getCartById(Long cardId) {
		return this.shoppingCarts.get(cardId);
	}
	
	public void addItemToCart(Key key,Product product) {
//		System.out.println(shoppingCarts.get(key.getuKey()));
		Integer Icount = shoppingCarts.get(key.getuKey()).getItems().get(new Long(product.getId()));
		if (Icount != null){
			Icount++;
		} else Icount = 1;
		shoppingCarts.get(key.getuKey()).getItems().put(new Long(product.getId()), new Integer(Icount));
		
	}
	
	
}	
