package com.sysmbiosis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.externel.services.RatingService;
import com.model.Rating;

@SpringBootTest
class UserServiceApplicationTests {

	@Test
	void contextLoads() {
	}

//	@Autowired
//	private RatingService ratingService;

//	@Test
//	public void createRating() {
//		Rating rating = Rating.builder().rating(10).ratingId("").userId("").hotelId("")
//				.feedback("using feign client to test").build();
//		Rating saveRating = ratingService.createRating(rating);
//		System.out.println("new rating created....!!!");
//	}
}
