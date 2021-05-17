package com.example.smartphone_shop;

import com.example.smartphone_shop.models.Smartphones;
import com.example.smartphone_shop.repository.SmartphonesRepository;
import com.example.smartphone_shop.services.SmartphonesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.Set;

@SpringBootApplication
public class SmartphoneShopApplication {



	private SmartphonesRepository smartphonesRepository;

	private SmartphonesService smartphonesService;


	public static void main(String[] args) {
		SpringApplication.run(SmartphoneShopApplication.class, args);

	}
	@Autowired
	public SmartphoneShopApplication(SmartphonesRepository smartphonesRepository,
									 SmartphonesService smartphonesService) {
		this.smartphonesService = smartphonesService;
		this.smartphonesRepository = smartphonesRepository;
	}

	@PostConstruct
	public void execute() {
		Smartphones smartphones = new Smartphones();

		smartphonesService.save(Smartphones.builder().smartphoneName("Samsung Galaxy S20").build());
		smartphonesService.save(Smartphones.builder().smartphoneName("iPhone 12 Pro Max").build());

		Set<Smartphones> smartphonesSet = smartphonesService.findAll();
		smartphonesSet.forEach(role -> System.out.println(smartphonesSet.toString()));

		smartphonesService.deleteByName("iPhone 12 Pro Max");
		Smartphones firstSmartphone = smartphonesService.findByName("Samsung Galaxy S20");
		System.out.println(firstSmartphone.toString());
	}


}
