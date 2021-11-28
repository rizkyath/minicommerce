package apap.tutorial.minicommerce.restservice;

import apap.tutorial.minicommerce.model.Item;
import apap.tutorial.minicommerce.rest.ItemDTO;

import java.util.List;

public interface ItemRestService {
    List<Item> getAllItem();
    Item getItemById(Long id);
    Item createItem(ItemDTO item);
    Item updateItem(ItemDTO item, Long id);
    void deleteItem(Long id);
}
