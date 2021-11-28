package apap.tutorial.minicommerce.rest;

import apap.tutorial.minicommerce.model.Item;

public class ItemDTO {
    public String title;
    public Double price;
    public String description;
    public String category;
    public String image;
    public RatingDTO rating;

    public Item convertToItem(){
        Item item = new Item();
        item.setTitle(title);
        item.setPrice(price);
        item.setDescription(description);
        item.setCategory(category);
        item.setImage(image);
        return item;
    }

    public Item convertToItem(Item item) {
        item.setTitle(title);
        item.setPrice(price);
        item.setDescription(description);
        item.setCategory(category);
        item.setImage(image);
        return item;
    }
    
}
