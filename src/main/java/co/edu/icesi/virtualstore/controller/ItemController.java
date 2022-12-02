package co.edu.icesi.virtualstore.controller;

import co.edu.icesi.virtualstore.api.ItemAPI;
import co.edu.icesi.virtualstore.dto.ItemDTO;
import co.edu.icesi.virtualstore.error.exception.StoreDemoError;
import co.edu.icesi.virtualstore.error.exception.StoreDemoException;
import co.edu.icesi.virtualstore.mapper.ItemMapper;
import co.edu.icesi.virtualstore.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static co.edu.icesi.virtualstore.constans.StoreErrorCode.*;

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
        return itemMapper.fromItem(itemService.updateItem(itemId,itemMapper.fromDTO(itemUpdated)));
    }

    @Override
    public ItemDTO createItem(ItemDTO itemDTO) {
        verifyItemNameEmpty(itemDTO.getName());
        verifyItemNameLength(itemDTO.getName());
        verifyItemDescriptionEmpty(itemDTO.getDescription());
        verifyItemDescriptionLength(itemDTO.getDescription());
        return itemMapper.fromItem(itemService.createItem(itemMapper.fromDTO(itemDTO)));
    }

    @Override
    public List<ItemDTO> getItems() {
        return itemService.getItems().stream().map(itemMapper::fromItem).collect(Collectors.toList());
    }


    private boolean verifyItemNameEmpty(String itemName){
        if(itemName==null||itemName.isEmpty()) {
            throw new StoreDemoException(HttpStatus.BAD_REQUEST, new StoreDemoError(I_C_03, I_C_03.getErrorMessage()));
        }else{
            return true;
        }
    }

    private boolean verifyItemNameLength(String itemName){

        if(itemName.length() <= 100){
            return true;
        }else{
            throw new StoreDemoException(HttpStatus.BAD_REQUEST, new StoreDemoError(I_C_01, I_C_01.getErrorMessage()));
        }
    }

    private boolean verifyItemDescriptionEmpty(String itemDescription){
        if(itemDescription==null||itemDescription.isEmpty()) {
            throw new StoreDemoException(HttpStatus.BAD_REQUEST, new StoreDemoError(I_C_04, I_C_04.getErrorMessage()));
        }else{
            return true;
        }
    }

    private boolean verifyItemDescriptionLength(String itemDescription){
        if(itemDescription.length() <= 255 ){
            return true;
        }else{
            throw new StoreDemoException(HttpStatus.BAD_REQUEST, new StoreDemoError(I_C_02, I_C_02.getErrorMessage()));
        }
    }


}


