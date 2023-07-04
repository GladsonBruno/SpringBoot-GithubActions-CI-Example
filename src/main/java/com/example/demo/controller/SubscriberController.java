package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Tier;
import com.example.demo.entity.Subscriber;
import com.example.demo.repository.SubscriberRepository;

@RestController
@RequestMapping("/api")
public class SubscriberController {

	@Autowired
	SubscriberRepository subscriberRepository;
	
	@GetMapping(path = "/subscribers")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<List<Subscriber>> findAll(@RequestParam( name = "tier", required = false ) Tier tier) {
		
		List<Subscriber> subscribers;
		
		if (tier == null) {
			
			subscribers = this.subscriberRepository.findAll();
			
		} else {
			
			subscribers = this.subscriberRepository.findByTier(tier);
			
		}
		
		return new ResponseEntity<>(subscribers, HttpStatus.OK);
		
	}
	
	@GetMapping(path = "/subscribers/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<Subscriber> findById(@PathVariable("id") int id) {
		
		Subscriber subscriber = this.subscriberRepository.findById(id);
		
		if (subscriber != null) {
			
			return new ResponseEntity<>(subscriber, HttpStatus.OK);
			
		} else {
			
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
		}
		
	}
	
	@PostMapping(path = "/subscribers")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<?> createSubscriber(@RequestBody Subscriber subscriber) {
		
		Subscriber newSubscriber  = new Subscriber();
		newSubscriber.setUsername(subscriber.getUsername());
		newSubscriber.setEmail(subscriber.getEmail());
		newSubscriber.setTier(subscriber.getTier());
		
		try {
			
			return new ResponseEntity<>(this.subscriberRepository.save(newSubscriber), HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
			
		}
		
	}
	
	@PutMapping(path = "/subscribers/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<Subscriber> updateSubscriber(@PathVariable("id") int id, @RequestBody Subscriber subscriber) {
	
		Subscriber subscriberToUpdate = this.subscriberRepository.findById(id);
		
		if (subscriberToUpdate == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		} else {
			
			subscriberToUpdate.setUsername(subscriber.getUsername());
			subscriberToUpdate.setEmail(subscriber.getEmail());
			
			return new ResponseEntity<>(subscriberToUpdate, HttpStatus.OK);
			
		}
		
	}
	
	@DeleteMapping(path = "/subscribers/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<?> deleteSubscriber (@PathVariable("id") int id) {
	
		Subscriber subscriberToDelete = this.subscriberRepository.findById(id);
		
		if (subscriberToDelete == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		} else {
			
			this.subscriberRepository.delete(subscriberToDelete);
			
			return new ResponseEntity<>(HttpStatus.OK);
			
		}	
		
	}
	
}
