package com.ecom.productcatalog.config;

import com.ecom.productcatalog.model.category;
import com.ecom.productcatalog.model.product;
import com.ecom.productcatalog.repository.CategoryRepository;
import com.ecom.productcatalog.repository.ProductRepository;
import jdk.jfr.Category;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Locale;

@Component
public class DataSeeder implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public DataSeeder(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        //clear all existing data
        productRepository.deleteAll();
        categoryRepository.deleteAll();

        // create categories
       category electronics = new category();
       electronics.setName("Electronics");

        category clothing = new category();
        clothing.setName("Clothing");

        category home = new category();
        home.setName("Home Kitchen");

        categoryRepository.saveAll(Arrays.asList(electronics,clothing,home));

        //create products

        product phone = new product();
        phone.setName("SmartPhone");
        phone.setDescription("Latest model smartPhone with amazing features");
        phone.setImageUrl("https://placehold.co/600x400");
        phone.setPrice(10000.00);
        phone.setCategory(electronics);
// ImageUrl = Placehold is the website where we get the dummy ImageUrl

        product laptop = new product();
        laptop.setName("Laptops");
        laptop.setDescription("Inbuilt A.I Laptops with amazing features");
        laptop.setImageUrl("https://placehold.co/600x400");
        laptop.setPrice(50000.00);
        laptop.setCategory(electronics);

        product hoddies = new product();
        hoddies.setName("Hoddies");
        hoddies.setDescription("Amine printed Hoddies");
        hoddies.setImageUrl("https://placehold.co/600x400");
        hoddies.setPrice(500.99);
        hoddies.setCategory(clothing);

        product bottles = new product();
        bottles.setName("Bottles");
        bottles.setDescription("All types of botles");
        bottles.setImageUrl("https://placehold.co/600x400");
        bottles.setPrice(400.99);
        bottles.setCategory(home);

        productRepository.saveAll(Arrays.asList(phone,hoddies,laptop,bottles));



    }
}
