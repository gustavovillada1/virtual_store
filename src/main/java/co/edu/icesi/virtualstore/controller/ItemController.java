package co.edu.icesi.virtualstore.controller;

import co.edu.icesi.virtualstore.api.ItemAPI;
import co.edu.icesi.virtualstore.dto.ItemDTO;
import co.edu.icesi.virtualstore.mapper.ItemMapper;
import co.edu.icesi.virtualstore.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class ItemController implements ItemAPI {

    private final ItemMapper itemMapper;

    private final ItemService itemService;


    @Override
    public ItemDTO getItem(UUID itemId) {
        return itemMapper.fromItem(itemService.getItem(itemId));
    }

    @Override
    public ItemDTO updateItem(UUID itemId, ItemDTO itemUpdated) {
        return null;
    }

    @Override
    public ItemDTO createItem(ItemDTO itemDTO) {
        return itemMapper.fromItem(itemService.createItem(itemMapper.fromDTO(itemDTO)));
    }

    @Override
    public List<ItemDTO> getItems() {
        return itemService.getItems().stream().map(itemMapper::fromItem).collect(Collectors.toList());
    }
}


