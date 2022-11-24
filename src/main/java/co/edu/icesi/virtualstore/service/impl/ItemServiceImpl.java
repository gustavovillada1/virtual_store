package co.edu.icesi.virtualstore.service.impl;

import co.edu.icesi.virtualstore.model.Item;
import co.edu.icesi.virtualstore.repository.ItemRepository;
import co.edu.icesi.virtualstore.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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
        return null;
    }

    @Override
    public Item createItem(Item item) {

        return itemRepository.save(item);
    }

    @Override
    public List<Item> getItems() {
        List<Item> itemsList= StreamSupport.stream(itemRepository.findAll().spliterator(),false).collect(Collectors.toList());
        return itemsList;
    }

    
}
