package com.example.smartphone_shop;

import com.example.smartphone_shop.model.Cart;
import com.example.smartphone_shop.model.Smartphone;
import com.example.smartphone_shop.model.User;
import com.example.smartphone_shop.repository.CartRepository;
import com.example.smartphone_shop.repository.SmartphoneRepository;
import com.example.smartphone_shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

@SpringBootApplication
public class SmartphoneShopApplication {

	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private SmartphoneRepository smartphoneRepository;
	@Autowired
	private UserRepository userRepository;
	public static void main(String[] args) {
		SpringApplication.run(SmartphoneShopApplication.class, args);

	}

//	@PostConstruct
//	public void execute() {
//		User user1 = User.builder()
//				.userCreationDate(LocalDateTime.now())
//				.password("asd")
//				.lastname("Dimitrov")
//				.firstname("Andrey")
//				.emailAddress("Andrey@abv.bg")
//				.build();
//		userRepository.save(user1);
//
//		Cart cart1 = Cart.builder()
//				.cartName("1")
//				.cartCreationDate(LocalDateTime.now())
//				.user(user1)
//				.build();
//		cartRepository.save(cart1);
//
//		Smartphone smartphone1 = Smartphone.builder()
//				.smartphonePrice("1500")
//				.smartphoneName("iPhone 12")
//				.cart(cart1)
//				.build();
//		smartphoneRepository.save(smartphone1);
//
//		User user2 = User.builder()
//				.userCreationDate(LocalDateTime.now())
//				.password("asda")
//				.lastname("Dimitrow")
//				.firstname("Andrei")
//				.emailAddress("Andrei@abv.bg")
//				.build();
//		userRepository.save(user2);
//
//		Cart cart2 = Cart.builder()
//				.cartName("2")
//				.cartCreationDate(LocalDateTime.now())
//				.user(user1)
//				.build();
//		cartRepository.save(cart2);
//
//		Smartphone smartphone2 = Smartphone.builder()
//				.smartphonePrice("1200")
//				.smartphoneName("iPhone 11")
//				.cart(cart2)
//				.build();
//		smartphoneRepository.save(smartphone2);
//
//
//	}





}
