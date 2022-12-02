package co.edu.icesi.virtualstore.service.impl;

import co.edu.icesi.virtualstore.constans.StoreErrorCode;
import co.edu.icesi.virtualstore.error.exception.StoreDemoError;
import co.edu.icesi.virtualstore.error.exception.StoreDemoException;
import co.edu.icesi.virtualstore.model.Item;
import co.edu.icesi.virtualstore.repository.ItemRepository;
import co.edu.icesi.virtualstore.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static co.edu.icesi.virtualstore.constans.StoreErrorCode.I_S_01;

@Service
@AllArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    @Override
    public Item getItem(UUID itemId) {
        return itemRepository.findById(itemId).orElse(null);
    }

    @Override
    public Item updateItem(UUID itemId, Item itemUpdated) {
        Item item = verifyItemIdInDatabase(itemId);
        item.setDescription(itemUpdated.getDescription());
        item.setPrice(itemUpdated.getPrice());
        item.setUrl(itemUpdated.getUrl());
        return itemRepository.save(item);
    }

    @Override
    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public List<Item> getItems() {
        return StreamSupport.stream(itemRepository.findAll().spliterator(),false).collect(Collectors.toList());
    }

    private Item verifyItemIdInDatabase(UUID itemId){
        Item item = itemRepository.findById(itemId).orElse(null);
        if(item == null){
            throw new StoreDemoException(HttpStatus.BAD_REQUEST, new StoreDemoError(I_S_01, I_S_01.getErrorMessage()));
        }
        return item;
    }
    
}
