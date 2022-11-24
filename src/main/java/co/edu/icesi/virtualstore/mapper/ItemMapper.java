package co.edu.icesi.virtualstore.mapper;

import co.edu.icesi.virtualstore.dto.ItemDTO;
import co.edu.icesi.virtualstore.model.Item;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    Item fromDTO(ItemDTO itemDTO);

    ItemDTO fromItem(Item item);
}
