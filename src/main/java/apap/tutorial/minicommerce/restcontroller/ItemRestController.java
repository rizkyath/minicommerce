package apap.tutorial.minicommerce.restcontroller;

import apap.tutorial.minicommerce.model.Item;
import apap.tutorial.minicommerce.rest.BaseResponse;
import apap.tutorial.minicommerce.restservice.ItemRestService;

import org.apache.coyote.http11.filters.IdentityOutputFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
        response.setStatus(200);
        response.setMessage("success");
        response.setResult(itemRestService.getItemById(idItem));

        return response;
    }
}
