package com.soupaproject.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.soupaproject.course.entities.Category;
import com.soupaproject.course.entities.Order;
import com.soupaproject.course.entities.Product;
import com.soupaproject.course.entities.User;
import com.soupaproject.course.entities.enums.OrderStatus;
import com.soupaproject.course.repository.CategoryRepository;
import com.soupaproject.course.repository.OrderRepository;
import com.soupaproject.course.repository.ProductRepository;
import com.soupaproject.course.repository.UserRepository;

@Profile("test")  //Roda essa aplicacao apenas quando estiver no perfil "test"                         
@Configuration
public class TestConfig implements CommandLineRunner {  //CommandLineRunner eh uma interface usada para executar quando o comando for executado !!!!!
        
        @Autowired
        private UserRepository userRepository;

        @Autowired
        private OrderRepository orderRepository;
        
        @Autowired
        private CategoryRepository categoryRepository;
        
        @Autowired
        private ProductRepository productRepository;

        @Override
        public void run(String... args) throws Exception {
            
            Category cat1 = new Category(null, "Electronics");
            Category cat2 = new Category(null, "Books");
            Category cat3 = new Category(null, "Computers");

            Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
            Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
            Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
            Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
            Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
                        
            categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
            productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));


            User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
            User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
            
            Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
            Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.DELIVERED, u2);
            Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.SHIPPED, u1);  
            
            userRepository.saveAll(Arrays.asList(u1, u2));
            orderRepository.saveAll(Arrays.asList(o1, o2, o3));
        } 

}
