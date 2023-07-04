package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.Tier;
import com.example.demo.entity.Subscriber;

import org.springframework.data.repository.CrudRepository;

public interface SubscriberRepository extends CrudRepository<Subscriber, Long> {

	List<Subscriber> findAll();

	Subscriber findById(long id);
	
	List<Subscriber> findByTier(Tier tier);
  
}
