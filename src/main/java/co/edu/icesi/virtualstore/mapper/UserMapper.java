package co.edu.icesi.virtualstore.mapper;

import co.edu.icesi.virtualstore.dto.UserCreateDTO;
import co.edu.icesi.virtualstore.dto.UserDTO;
import co.edu.icesi.virtualstore.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

     User fromDTO(UserDTO userDTO);
     User fromCreateDTO(UserCreateDTO userCreateDTO);
     UserDTO fromUser(User user);


}
