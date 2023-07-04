package com.example.demo.repository;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Subscriber;

@SpringBootTest
class UserRepositoryTest {

	@Autowired
	SubscriberRepository subscriberRepository;
	
	@Test
	void testIfUserOneExists() {
		
		Subscriber user = subscriberRepository.findById(1);
		
		Assertions.assertNotNull(user);
		
		Subscriber expectedSubscriber = new Subscriber();
		expectedSubscriber.setId((long) 1);
		expectedSubscriber.setUsername("user-1");
		expectedSubscriber.setEmail("user-1@gmail.com");
		
		Assertions.assertEquals(expectedSubscriber.getId(), user.getId());
		Assertions.assertEquals(expectedSubscriber.getUsername(), user.getUsername());
		Assertions.assertEquals(expectedSubscriber.getEmail(), user.getEmail());
		
	}
	
	@Test
	void testIfUserElevenNotExists() {
		
		Subscriber subscriber = subscriberRepository.findById(11);
		
		Assertions.assertNull(subscriber);
		
	}
	
	@Test
	void testGetAllUsers() {
		
		List<Subscriber> subscribers = subscriberRepository.findAll();
		
		Assertions.assertEquals(5, subscribers.size());
		
	}
	
}
