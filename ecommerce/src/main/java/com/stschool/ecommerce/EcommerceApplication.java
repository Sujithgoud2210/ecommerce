package com.stschool.ecommerce;

import com.stschool.ecommerce.entity.Product;
import com.stschool.ecommerce.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@SpringBootApplication
class EcommerceApplication implements CommandLineRunner {
    private final ProductRepository productRepository;


    public static void main(String[] args) {
        SpringApplication.run(EcommerceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if (productRepository.count() > 0) {
            return;
        }

        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new ClassPathResource("products.csv")
                                .getInputStream()
                )
        );

        List<Product> products = br.lines()

                .skip(1)

                .map(line -> line.split(",", -1))

                .map(data -> Product.builder()
                        .name(data[0])
                        .maxRetailPrice(Integer.parseInt(data[1]))
                        .discountPercentage(Float.parseFloat(data[2]))
                        .isAvailable(Boolean.parseBoolean(data[3]))
                        .company(data[4])
                        .category(data[5])
                        .manufacturedYear(Integer.parseInt(data[6]))
                        .build())

                .toList();

        productRepository.saveAll(products);

        log.info("{}  -> Products loaded successfully ", getClass().getName());
    }
}
