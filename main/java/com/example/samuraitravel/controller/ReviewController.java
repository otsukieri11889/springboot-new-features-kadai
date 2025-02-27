package com.example.samuraitravel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.samuraitravel.entity.House;
import com.example.samuraitravel.entity.Review;
import com.example.samuraitravel.service.HouseService;
import com.example.samuraitravel.service.ReviewService;

@Controller
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private HouseService houseService;

    @GetMapping("/houses/{houseId}/reviews/register")
    public String showReviewForm(@PathVariable Long houseId, Model model) {
        House house = houseService.getHouseById(houseId);
        model.addAttribute("house", house);
        return "reviews/register";
    }

    @PostMapping("/houses/{houseId}/reviews/register")
    public String registerReview(@PathVariable Long houseId, @RequestParam String name, @RequestParam String comment, @RequestParam int rating) {
        Review review = new Review();
        review.setReview_text(comment); // comment を設定します
        review.setRating(rating);
        review.setHouse(houseService.getHouseById(houseId)); // house を設定します
        reviewService.saveReview(review); // deleteReview を saveReview に変更
        return "redirect:/houses/" + houseId + "/reviews";
    }

    @GetMapping("/houses/{houseId}/reviews")
    public String showReviews(@PathVariable Long houseId, Model model, Pageable pageable) {
        Page<Review> reviewPage = reviewService.getReviewsByHouseId(houseId, pageable); // pageable を渡します
        House house = houseService.getHouseById(houseId);
        model.addAttribute("reviewPage", reviewPage);
        model.addAttribute("house", house);
        return "reviews";
    }
}