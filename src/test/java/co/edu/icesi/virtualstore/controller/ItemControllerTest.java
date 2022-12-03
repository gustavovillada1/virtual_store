package co.edu.icesi.virtualstore.controller;


import co.edu.icesi.virtualstore.constans.StoreErrorCode;
import co.edu.icesi.virtualstore.dto.ItemDTO;
import co.edu.icesi.virtualstore.error.exception.StoreDemoException;
import co.edu.icesi.virtualstore.mapper.ItemMapper;
import co.edu.icesi.virtualstore.mapper.ItemMapperImpl;
import co.edu.icesi.virtualstore.model.Item;
import co.edu.icesi.virtualstore.service.ItemService;
import co.edu.icesi.virtualstore.service.impl.ItemServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ItemControllerTest {

    private ItemService itemService;

    private ItemController itemController;

    private ItemMapper itemMapper;

    @BeforeEach
    public void init(){
        itemService = mock(ItemServiceImpl.class);
        itemMapper = new ItemMapperImpl();
        itemController = new ItemController(itemMapper, itemService);
    }


    @Test
    public void testCreateAnimal(){
        UUID itemId=UUID.randomUUID();
        when(itemService.createItem(any())).thenReturn(new Item(itemId,"Toyota TXL","Toyota txl modelo 2011 - llantas nuevas ",150000000,""));
        ItemDTO itemTest = new ItemDTO(itemId,"Toyota TXL","Toyota txl modelo 2011 - llantas nuevas ",150000000,"");
        assertEquals(itemTest.getName(), itemController.createItem(itemTest).getName());
    }


    @Test
    public void testGetAnimals(){
        ArrayList<Item> list= new ArrayList<Item>();
        UUID itemId=UUID.randomUUID();

        list.add(new Item(itemId,"Toyota TXL","Toyota txl modelo 2011 - llantas nuevas ",150000000,""));
        when(itemService.getItems()).thenReturn(list);
        assertTrue(itemController.getItems().get(0).getItemId().equals(itemId));
    }


    @Test
    public void testNameLength(){
        ItemDTO itemDTO = new ItemDTO(UUID.randomUUID(),"Toyota TXL","Toyota txl modelo 2011 - llantas nuevas ",150000000,"");
        String itemName = "";
        for (int i=0;i<110;i++){
            itemName+="X";
        }
        itemDTO.setName(itemName);
        StoreDemoException exception =assertThrows(StoreDemoException.class, () -> {
            itemController.createItem(itemDTO);} );
        assertEquals(StoreErrorCode.I_C_01,exception.getError().getCode());
    }


    @Test
    public void testNameEmpty(){
        ItemDTO itemDTO = new ItemDTO(UUID.randomUUID(),"","Toyota txl modelo 2011 - llantas nuevas ",150000000,"");
        try{
            itemController.createItem(itemDTO);
            fail();
        }catch (StoreDemoException exception){
            assertEquals(StoreErrorCode.I_C_03,exception.getError().getCode());
        }
    }

    @Test
    public void testDescriptionLength(){
        ItemDTO itemDTO = new ItemDTO(UUID.randomUUID(),"Toyota TXL","Toyota txl modelo 2011 - llantas nuevas ",150000000,"");
        String itemDescription = "";
        for (int i=0;i<960;i++){
            itemDescription+="X";
        }
        itemDTO.setDescription(itemDescription);
        StoreDemoException exception =assertThrows(StoreDemoException.class, () -> {
            itemController.createItem(itemDTO);} );
        assertEquals(StoreErrorCode.I_C_02,exception.getError().getCode());
    }


    @Test
    public void testDescriptionEmpty(){
        ItemDTO itemDTO = new ItemDTO(UUID.randomUUID(),"Toyota TXL","",150000000,"https://www.elcarrocolombiano.com/wp-content/uploads/2020/09/20200109-TOYOTA-LAND-CRUISER-2021-PORTADA.jpg");
        try{
            itemController.createItem(itemDTO);
            fail();
        }catch (StoreDemoException exception){
            assertEquals(StoreErrorCode.I_C_04,exception.getError().getCode());
        }
    }




    @Test
    public void testFindItem(){
        UUID itemId = UUID.randomUUID();

        when(itemService.getItem(itemId)).thenReturn(new Item(itemId,"Toyota TXL","Toyota txl modelo 2011 - llantas nuevas ",150000000,""));

        ItemDTO itemResult= itemController.getItem(itemId);
        assertEquals(itemResult.getItemId(),itemId);
    }





}

