package co.edu.icesi.virtualstore.api;

import co.edu.icesi.virtualstore.dto.ItemDTO;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RequestMapping("/items")
public interface ItemAPI {

    @GetMapping("/{itemId}")
    public ItemDTO getItem(@PathVariable UUID itemId);

    @PutMapping("/{itemId}")
    public ItemDTO updateItem(@PathVariable UUID itemId, @RequestBody  ItemDTO itemUpdated);

    @PostMapping()
    public ItemDTO createItem(@RequestBody @Valid ItemDTO itemDTO);

    @GetMapping()
    public List<ItemDTO> getItems();

}
