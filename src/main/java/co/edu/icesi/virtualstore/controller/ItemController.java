package co.edu.icesi.virtualstore.controller;

import co.edu.icesi.virtualstore.api.ItemAPI;
import co.edu.icesi.virtualstore.constans.ItemErrorCode;
import co.edu.icesi.virtualstore.dto.ItemDTO;
import co.edu.icesi.virtualstore.error.StoreErrorCode;
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
            throw new StoreDemoException(HttpStatus.BAD_REQUEST, new StoreDemoError(ItemErrorCode.CODE_03, "El nombre del item no debe estar vacio."));
        }else{
            return true;
        }
    }

    private boolean verifyItemNameLength(String itemName){

        if(itemName.length() <= 100){
            return true;
        }else{
            throw new StoreDemoException(HttpStatus.BAD_REQUEST, new StoreDemoError(ItemErrorCode.CODE_01,"El nombre del item no debe ser mayor a 100 caracteres"));
        }
    }

    private boolean verifyItemDescriptionEmpty(String itemDescription){
        if(itemDescription==null||itemDescription.isEmpty()) {
            throw new StoreDemoException(HttpStatus.BAD_REQUEST, new StoreDemoError(ItemErrorCode.CODE_04, "La descripción del item está vacía"));
        }else{
            return true;
        }
    }

    private boolean verifyItemDescriptionLength(String itemDescription){
        if(itemDescription.length() <= 255 ){
            return true;
        }else{
            throw new StoreDemoException(HttpStatus.BAD_REQUEST, new StoreDemoError(ItemErrorCode.CODE_02,"La descripción del item no debe ser mayor a 255 caracteres"));
        }
    }


}


