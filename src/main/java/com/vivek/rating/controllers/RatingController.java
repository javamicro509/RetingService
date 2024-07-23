package com.vivek.rating.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vivek.rating.entities.Rating;
import com.vivek.rating.service.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {
	
	@Autowired
	private RatingService ratingService;
	
	@PostMapping
	public ResponseEntity<Rating> create(@RequestBody Rating rating){
		return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.saveRating(rating));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Rating> getRatingsById(@PathVariable String id){
		return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRatingById(id));
	}
	
	@GetMapping
	public ResponseEntity<List<Rating>> getRatings(){
		return ResponseEntity.status(HttpStatus.OK).body(ratingService.getAllrating());
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<List<Rating>> getRatingsByUseerId(@PathVariable String id){
		return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRatingByUserId(id));
	}
	
	@GetMapping("/hotels/{id}")
	public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable String id){
		return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRatingByHotelId(id));
	}

}
