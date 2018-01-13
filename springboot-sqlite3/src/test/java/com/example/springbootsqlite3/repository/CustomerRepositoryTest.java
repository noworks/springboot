package com.example.springbootsqlite3.repository;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.springbootsqlite3.entity.Customer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerRepositoryTest {

	private static final Logger log = LoggerFactory.getLogger(CustomerRepositoryTest.class);

	@Autowired
	private CustomerRepository repository;

	public void setup() {
		repository.deleteAll();
	}

	@Test
	public void test() {
		long start = System.currentTimeMillis();

		long count = 365 * 24 * 60 * 2;

		List<Customer> list = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			Customer c = new Customer("Jack", "Bauer");
			list.add(c);
		}
		repository.save(list);

		long end = System.currentTimeMillis();
		log.info("件数=" + repository.count() + " 件");
		log.info("処理時間=" + (end - start) + " ms");

	}

}
