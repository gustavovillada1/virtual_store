package co.edu.icesi.virtualstore.service;

import co.edu.icesi.virtualstore.mapper.ItemMapper;
import co.edu.icesi.virtualstore.mapper.ItemMapperImpl;
import co.edu.icesi.virtualstore.model.Item;
import co.edu.icesi.virtualstore.repository.ItemRepository;
import co.edu.icesi.virtualstore.service.impl.ItemServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ItemServiceTest {

    private ItemRepository itemRepository;

    private ItemService itemService;

    private ItemMapper itemMapper;


    @BeforeEach
    public void init(){
        itemRepository = mock(ItemRepository.class);
        itemMapper = new ItemMapperImpl();
        itemService = new ItemServiceImpl(itemRepository);

    }


    @Test
    public void testCreateItem(){
        Item item = new Item(UUID.randomUUID(),"Toyota TXL","120.000 kilometros, modelo 2018","",150000000);

        when(itemRepository.save(ArgumentMatchers.any())).thenReturn(item);

        Item item2 = itemService.createItem(item);
        assertEquals(item,item2);
    }

    @Test
    public void testGetItems(){
        when(itemRepository.findAll()).thenReturn(new ArrayList<Item>());
        List<Item> items = itemService.getItems();
        assertTrue(items.isEmpty());
    }

}
