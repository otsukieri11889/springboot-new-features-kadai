package com.example.samuraitravel.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.samuraitravel.entity.Review;
import com.example.samuraitravel.repository.ReviewRepository;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    
    public Page<Review> getReviewsByHouseId(Long houseId, Pageable pageable) {
        return reviewRepository.findByHouseId(houseId);
    }
    
    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }

    public void deleteReview(Long reviewId) {
        reviewRepository.deleteById(reviewId);
    }
   

    @Transactional
    public Review editReview(Long reviewId, Review newReview) {
        return reviewRepository.findById(reviewId).map(review -> {
            review.setReview_text(newReview.getReview_text());
            review.setRating(newReview.getRating());
            return reviewRepository.save(review);
        }).orElseGet(() -> {
            newReview.setId(reviewId);
            return reviewRepository.save(newReview);
        });
    }
    
        