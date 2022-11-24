package co.edu.icesi.virtualstore.service;

import co.edu.icesi.virtualstore.dto.ItemDTO;
import co.edu.icesi.virtualstore.model.Item;
import co.edu.icesi.virtualstore.model.User;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

public interface ItemService {

    public Item getItem(@PathVariable UUID itemId);

    public Item updateItem(@PathVariable UUID itemId, @RequestBody  Item itemUpdated);

    public Item createItem(@RequestBody @Valid Item item);

    public List<Item> getItems();
}
