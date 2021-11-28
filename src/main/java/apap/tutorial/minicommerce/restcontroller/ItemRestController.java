package apap.tutorial.minicommerce.restcontroller;

import apap.tutorial.minicommerce.model.Item;
import apap.tutorial.minicommerce.rest.BaseResponse;
import apap.tutorial.minicommerce.rest.ItemDTO;
import apap.tutorial.minicommerce.restservice.ItemRestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;
import java.text.ParseException;

@RestController
@RequestMapping("/api")
public class ItemRestController {

    @Autowired
    private ItemRestService itemRestService;

    @GetMapping(value = "/item")
    private BaseResponse<List<Item>> getAllItem() {
        BaseResponse<List<Item>> response = new BaseResponse<>();
        response.setStatus(200);
        response.setMessage("success");
        response.setResult(itemRestService.getAllItem());

        return response;
    }

    @GetMapping(value = "/item/{idItem}")
    private BaseResponse<Item> getItemById(@PathVariable("idItem") Long idItem) {
        BaseResponse<Item> response = new BaseResponse<>();
        try {
            Item item = itemRestService.getItemById(idItem);
            response.setStatus(200);
            response.setMessage("success");
            response.setResult(item);
        } catch (Exception e) {
            response.setStatus(400);
            response.setMessage(e.toString());
            response.setResult(null);
        }
        return response;
    }

    @PostMapping(value = "/item")
    private BaseResponse<Item> addItem(
            @Valid @RequestBody ItemDTO item,
            BindingResult bindingResult) throws ParseException {
        BaseResponse<Item> response = new BaseResponse<>();
        if (bindingResult.hasFieldErrors()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Request Body has invalid type or missing field");
        } else {
            try {
                Item newItem = itemRestService.createItem(item);
                response.setStatus(201);
                response.setMessage("created");
                response.setResult(newItem);
            } catch (Exception e) {
                response.setStatus(400);
                response.setMessage(e.toString());
                response.setResult(null);
            }
            return response;
        }
    }

    @PutMapping(value = "/item/{id}")
    private BaseResponse<Item> updateItem(
            @Valid @RequestBody ItemDTO item,
            @PathVariable(value = "id") Long id,
            BindingResult bindingResult) throws ParseException {
        BaseResponse<Item> response = new BaseResponse<>();
        if (bindingResult.hasFieldErrors()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Request Body has invalid type or missing field");
        } else {
            try {
                Item newItem = itemRestService.updateItem(item, id);
                response.setStatus(200);
                response.setMessage("updated");
                response.setResult(newItem);
            } catch (Exception e) {
                response.setStatus(400);
                response.setMessage(e.toString());
                response.setResult(null);
            }
            return response;
        }
    }

    @DeleteMapping(value = "/item/{idItem}")
    private ResponseEntity<String> deleteItem(@PathVariable("idItem") Long idItem) {
        try {
            itemRestService.deleteItem(idItem);
            return ResponseEntity.ok("Item with id " + String.valueOf(idItem) + " Deleted!");
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Item with id " + String.valueOf(idItem) + " Not Found.");
        }
    }
}
