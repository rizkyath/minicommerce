package apap.tutorial.minicommerce.restservice;

import apap.tutorial.minicommerce.model.Cart;
import apap.tutorial.minicommerce.repository.CartDB;
import apap.tutorial.minicommerce.repository.ItemDB;
import apap.tutorial.minicommerce.rest.CartDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CartRestServiceImpl implements CartRestService {
    @Autowired
    CartDB cartDB;

    @Autowired
    ItemDB itemDB;

    @Override
    public List<Cart> getAllCartItems() {
        return cartDB.findAll();
    }

    @Override
    public Cart getCartItemById(Long id) {
        return cartDB.findById(id).get();
    }

    @Override
    public Cart createUpdateCartItem(CartDTO cartDTO) {
        Optional<Cart> cartOpt = cartDB.findByItem(cartDTO.idItem);
        if (cartOpt.isPresent()){
            Cart cart = cartOpt.get();
            cart.setQuantity(cart.getQuantity() + cartDTO.quantity);
            return cartDB.save(cart);
        }
        Cart cart = new Cart();
        cart.setItem(itemDB.findById(cartDTO.idItem).get());
        cart.setQuantity(cartDTO.quantity);
        return cartDB.save(cart);
    }

    @Override
    public void deleteAllCartItem() {
        cartDB.deleteAll();
    }

    @Override
    public void deleteCartItem(Long id) {
        cartDB.deleteById(id);
    }
   
}
