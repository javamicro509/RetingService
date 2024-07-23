package com.vivek.rating.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vivek.rating.entities.Rating;
import com.vivek.rating.exceptions.ResourceNotFoundException;
import com.vivek.rating.repositories.RatingRepository;
import com.vivek.rating.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	private RatingRepository ratingRepository;
	
	@Override
	public Rating saveRating(Rating rating) {
		String id = UUID.randomUUID().toString();
		rating.setRatingId(id);
		return ratingRepository.save(rating);
	}

	@Override
	public List<Rating> getAllrating() {
		return ratingRepository.findAll();
	}

	@Override
	public Rating getRatingById(String id) {
		return ratingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Rating with given id not found"));
	}


	@Override
	public List<Rating> getRatingByUserId(String id) {
		return ratingRepository.findByUserId(id);
	}

	@Override
	public List<Rating> getRatingByHotelId(String id) {
		return ratingRepository.findByHotelId(id);
	}

}
