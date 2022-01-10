package apap.tutorial.minicommerce.restcontroller;

import apap.tutorial.minicommerce.model.Cart;
import apap.tutorial.minicommerce.rest.BaseResponse;
import apap.tutorial.minicommerce.rest.CartDTO;
import apap.tutorial.minicommerce.restservice.CartRestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import javax.validation.Valid;
import java.text.ParseException;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/cart")
public class CartRestController {

    @Autowired
    private CartRestService cartRestService;

    @GetMapping()
    private BaseResponse<List<Cart>> getAllCartItem() {
        BaseResponse<List<Cart>> response = new BaseResponse<>();
        response.setStatus(200);
        response.setMessage("success");
        response.setResult(cartRestService.getAllCartItems());

        return response;
    }

    @PostMapping()
    private BaseResponse<Cart> createUpdateCart(
            @Valid @RequestBody CartDTO cart,
            BindingResult bindingResult) throws ParseException {
        BaseResponse<Cart> response = new BaseResponse<>();
        if (bindingResult.hasFieldErrors()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Request Body has invalid type or missing field");
        } else {
            try {
                Cart newCart = cartRestService.createUpdateCartItem(cart);
                response.setStatus(200);
                response.setMessage("success");
                response.setResult(newCart);
            } catch (Exception e) {
                response.setStatus(400);
                response.setMessage(e.toString());
                response.setResult(null);
            }
            return response;
        }
    }

    @GetMapping(value = "/checkout")
    private ResponseEntity<String> deleteAllCartItem() {
        cartRestService.checkout();
        return ResponseEntity.ok("Checkout items success!");
    }
}