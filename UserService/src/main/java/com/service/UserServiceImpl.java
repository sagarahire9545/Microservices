package com.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dao.UserRepository;
import com.exception.RsourceNotFoundException;
import com.externel.services.HotelService;
import com.model.Hotel;
import com.model.Rating;
import com.model.User;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private HotelService hotelService;

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public User saveUser(User user) {
		String randomUUID = UUID.randomUUID().toString();
		user.setUserId(randomUUID);
		return userRepository.save(user);
	}

	// get all users
	@Override
	public List<User> getAllUsers() {

		return userRepository.findAll();
	}

	// get users with using user id
	@Override
	public User getByUserId(String userId) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new RsourceNotFoundException("User is not found on server with perticular id"));

		// fetch ratings with user Id with Rest template
		// localhost:8080/ratings/users/6e57fb12-ec78-439d-96d9-f4d44c07088b

		// Fetch ratings for a specific user from RATING-SERVICE
		Rating[] ratingOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/" + user.getUserId(),
				Rating[].class);

		// Convert the array of ratings into a List
		List<Rating> ratings = Arrays.stream(ratingOfUser).toList();

		// Log the received ratings for debugging
		logger.info("{}", ratingOfUser);

		// Create a List to store ratings with associated hotel information
		List<Rating> ratingList = ratings.stream().map(rating -> {
			
			// http://localhost:8083/hotels/c32d1930-a88d-4b76-b253-8a56fcd97f14s
			// api call to hotel service to get the hotel

			// Make an API call to HOTEL-SERVICE to get hotel information
		    //ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/" + rating.getHotelId(), Hotel.class);
			
			// Extract the hotel information from the response
		//	Hotel hotel = forEntity.getBody();
			
			//for externel service
			Hotel hotel = hotelService.getHotel(rating.getHotelId());
			
			// Log the HTTP response status code for debugging
	//		logger.info("response status code:{}", forEntity.getStatusCode());

			// set the hotel to rating
			rating.setHotel(hotel);
			
			
			// return the rating
			return rating;

		}).collect(Collectors.toList());

		
		// Set the updated list of ratings with hotel information to the user
		user.setRatings(ratingList);

		return user;
	}

}
