package com.example.samuraitravel.form;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ReviewEditForm {
   @NotNull
	private Integer id;
   @NotNull(message = "評価を選択してください")
   @Range(min = 1,max = 5,message ="評価は1～5のいずれかを選択してください")
    private Integer rating;
   @NotBlank(message ="コメントを入力してください")
   @Length(max = 300,message ="コメントは300文字以内で入力してください")
    private String review_text;		
	
// コンストラクタ
public ReviewEditForm(Integer id, Integer rating, String review_text) {
    this.id = id;
    this.rating = rating;
    this.review_text = review_text;
}

// ゲッターとセッター
public Integer getId() {
    return id;
}

public void setId(Integer id) {
    this.id = id;
}

public Integer getRating() {
    return rating;
}

public void setRating(Integer rating) {
    this.rating = rating;
}

public String getReview_text() {
    return review_text;
}

public void setReviewText(String reviewText) {
    this.review_text = review_text;
}
}
    