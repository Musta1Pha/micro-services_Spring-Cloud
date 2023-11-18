package org.sid.inventoryservice;

import org.sid.inventoryservice.entities.Product;
import org.sid.inventoryservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProductRepository productRepository , RepositoryRestConfiguration restConfiguration){
        return args -> {

          restConfiguration.exposeIdsFor(Product.class);
          productRepository.saveAll(
                  List.of(
                          Product.builder().name("Computer").price(Math.random() * 3454).quantity(200).build(),
                          Product.builder().name("TV").price(Math.random() * 3454).quantity(150).build(),
                          Product.builder().name("Smartphone").price(Math.random() * 3454).quantity(1200).build()
                  )
          );

          productRepository.findAll().forEach(System.out::println);

        };
    }

}
