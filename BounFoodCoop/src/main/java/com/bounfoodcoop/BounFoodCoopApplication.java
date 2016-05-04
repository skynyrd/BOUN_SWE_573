package com.bounfoodcoop;

import com.bounfoodcoop.repository.IProductRepository;
import com.bounfoodcoop.service.DataLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BounFoodCoopApplication {

	@Autowired
	IProductRepository productRepository;

	@Autowired
	DataLoader dataLoader;

	public static void main(String[] args) {
		SpringApplication.run(BounFoodCoopApplication.class, args);
	}
}
