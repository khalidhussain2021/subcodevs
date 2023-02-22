package com.drezz.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.drezz.dto.Product;

@Service
public class ProductService {
	
	 List<Product> products=new ArrayList<>();
	 Product p=new Product(1,"name",1,200);
	 Product p1=new Product(1,"name",1,200);

//	 @PostConstruct
//	 public void loadProductFromDB() {
//		 products = IntStream.rangeClosed(1, 100)
//				 .mapToObj(i->Product.builder()
//				 .productId(i)
//				 .name("product" + i)
//				 .qty(new Random().nextInt(10))
//				 .price(new Random().nextInt(500)).build()
//				 .collect(Collectors.toList());
//	 }
	 
	 public List<Product> getProducts() {
		 return products;
	 }
	 
	 public Product getProduct(int id) {
		return products
				.stream() 
				.filter(product->product.getProductId()==id)
				.findAny().orElseThrow(()->new RuntimeException());
	 }
}
