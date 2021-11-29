package apap.tutorial.minicommerce.restservice;

import apap.tutorial.minicommerce.model.Item;
import apap.tutorial.minicommerce.repository.ItemDB;
import apap.tutorial.minicommerce.rest.ItemDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ItemRestServiceImpl implements ItemRestService {
    @Autowired
    ItemDB itemDB;

    @Override
    public List<Item> getAllItem() {
        return itemDB.findAll();
    }

    @Override
    public Item getItemById(Long id) {
        return itemDB.findById(id).get();
    }

    @Override
    public void deleteItem(Long id) {
        itemDB.deleteById(id);        
    }

    @Override
    public Item createItem(ItemDTO item) {
        Item newItem = item.convertToItem();
        // Rating rating = ratingDB.save(item.rating.convertToRating());
        // newItem.setRating(rating);
        return itemDB.save(newItem);
    }

    @Override
    public Item updateItem(ItemDTO itemDTO, Long id) {
        Item item = getItemById(id);
        item = itemDTO.convertToItem(item);

        // Rating rating = item.getRating();
        // rating = itemDTO.rating.convertToRating(rating);
        // item.setRating(rating);
        
        return itemDB.save(item);
    }
}
