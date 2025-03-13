package com.example.samuraitravel.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.samuraitravel.entity.House;
import com.stripe.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

	public Page<Review> findByHouseOrderByCreatedAtDesc(House house,Pageable pageable);

	public void save(com.example.samuraitravel.entity.Review review);

	
}