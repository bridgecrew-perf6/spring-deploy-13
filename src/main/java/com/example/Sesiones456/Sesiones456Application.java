package com.example.Sesiones456;

import com.example.Sesiones456.entities.LapTop;
import com.example.Sesiones456.repositories.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;



@SpringBootApplication
public class Sesiones456Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Sesiones456Application.class, args);
		LaptopRepository repository = context.getBean(LaptopRepository.class);
/*
		LapTop lapTop1 = new LapTop(null, "Hp", "Pavilion", 15.5, 595.5);
		LapTop lapTop2 = new LapTop(null, "Microsoft", "Surface", 13.5, 895.5);

		repository.save(lapTop1);
		repository.save(lapTop2);

 */

	}

}
