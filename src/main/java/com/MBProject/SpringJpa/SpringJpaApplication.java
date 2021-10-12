package com.MBProject.SpringJpa;

import com.MBProject.SpringJpa.model.Product;
import com.MBProject.SpringJpa.model.User;
import com.MBProject.SpringJpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJpaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User post = new User("one", "two");
		Product comment1 = new Product("name1",1,6);
		Product comment2 = new Product("name2",2,5);

		post.getProducts().add(comment1);
		post.getProducts().add(comment2);

		this.userRepository.save(post);
	}
}
