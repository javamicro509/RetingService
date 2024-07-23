package com.vivek.rating.service;

import java.util.List;

import com.vivek.rating.entities.Rating;

public interface RatingService {

	public Rating saveRating(Rating rating);
	
	public List<Rating> getAllrating();
	
	public Rating getRatingById(String id);
	
	public List<Rating> getRatingByUserId(String id);
	
	public List<Rating> getRatingByHotelId(String id);
}
