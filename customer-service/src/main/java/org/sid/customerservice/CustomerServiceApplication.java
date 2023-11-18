package org.sid.customerservice;

import org.sid.customerservice.entities.Customer;
import org.sid.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
        return args -> {
            Stream.of("Mustapha" , "Ghita" , "Anwar" , "Mouad").forEach(p -> {
                Customer customer = Customer.builder()
                        .name(p)
                        .email(p+"@gmail.com")
                        .build();
                customerRepository.save(customer);
            });

            customerRepository.findAll().forEach(System.out::println);

        };
    }

}
