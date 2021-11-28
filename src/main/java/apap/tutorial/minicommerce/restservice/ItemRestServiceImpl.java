package apap.tutorial.minicommerce.restservice;

import apap.tutorial.minicommerce.model.Item;
import apap.tutorial.minicommerce.repository.ItemDB;
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
}
