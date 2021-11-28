package apap.tutorial.minicommerce.rest;

import apap.tutorial.minicommerce.model.Rating;

public class RatingDTO {
    public Double rate;
    public Integer count;

    public Rating convertToRating() {
        Rating rating = new Rating();
        rating.setCount(count);
        rating.setRate(rate);
        return rating;
    }
    
    public Rating convertToRating(Rating rating) {
        rating.setCount(count);
        rating.setRate(rate);
        return rating;
    }
}
