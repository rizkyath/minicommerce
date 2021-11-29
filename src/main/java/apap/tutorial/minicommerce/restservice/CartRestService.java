package apap.tutorial.minicommerce.restservice;

import apap.tutorial.minicommerce.model.Cart;
import apap.tutorial.minicommerce.rest.CartDTO;

import java.util.List;

public interface CartRestService {
    List<Cart> getAllCartItems();
    Cart getCartItemById(Long id);
    Cart createUpdateCartItem(CartDTO cartDTO);
    void deleteAllCartItem();
    void deleteCartItem(Long id);
}
