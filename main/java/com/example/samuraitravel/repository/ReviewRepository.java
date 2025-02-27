package com.example.samuraitravel.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.samuraitravel.entity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
   //必要なものがあれば随時追加
	List<Review> findByHouseId(Long houseId);

	Page<Review> findById(Integer reviewId);
}

