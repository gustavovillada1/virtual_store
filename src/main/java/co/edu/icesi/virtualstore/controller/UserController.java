package co.edu.icesi.virtualstore.controller;

import co.edu.icesi.virtualstore.api.UserAPI;
import co.edu.icesi.virtualstore.dto.UpdateUserRolDTO;
import co.edu.icesi.virtualstore.dto.UserCreateDTO;
import co.edu.icesi.virtualstore.dto.UserDTO;
import co.edu.icesi.virtualstore.error.exception.StoreDemoError;
import co.edu.icesi.virtualstore.error.exception.StoreDemoException;
import co.edu.icesi.virtualstore.mapper.UserMapper;
import co.edu.icesi.virtualstore.model.Role;
import co.edu.icesi.virtualstore.service.UserService;
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
@CrossOrigin
public class UserController implements UserAPI {

    public final String EMAIL_PATTERN = "^[a-zA-Z0-9._-]+@[a-zA-Z.]+\\.[a-zA-Z]+$";
    public final String PHONE_PATTERN = "^\\+57[0-9]{10}$";

    public final UserService userService;
    public final UserMapper userMapper;

    @Override
    public UserDTO getUser(UUID userId) {
        return userMapper.fromUser(userService.getUser(userId));
    }

    @Override
    public UserDTO createUser(UserCreateDTO userCreateDTO) {
        verifyEmailOrPhonePresence(userCreateDTO);
        return userMapper.fromUser( userService.createUser(userMapper.fromCreateDTO(userCreateDTO), userCreateDTO.getRoleId()) );
    }

    @Override
    public UserDTO updateUserRol(UUID userId, UpdateUserRolDTO newRoleId) {
        return userMapper.fromUser(userService.updateUserRol(userId, newRoleId.getRoleId()));
    }

    @Override
    public List<UserDTO> getUsers() {
        return userService.getUsers().stream().map(userMapper::fromUser).collect(Collectors.toList());
    }


    private void verifyEmailOrPhonePresence(UserCreateDTO userCreateDTO){
        if(userCreateDTO.getEmail() == null && userCreateDTO.getPhone() == null){
            throw new StoreDemoException(HttpStatus.BAD_REQUEST, new StoreDemoError(U_C_01, I_C_04.toString()));
        }

        if(userCreateDTO.getEmail() != null){
            verifyUserEmail(userCreateDTO.getEmail());
        }

        if(userCreateDTO.getPhone() != null){
            verifyUserPhone(userCreateDTO.getPhone());
        }
    }

    private void verifyUserEmail(String email){
        if(email.matches(EMAIL_PATTERN) == false){
            throw new StoreDemoException(HttpStatus.BAD_REQUEST, new StoreDemoError(U_C_02, U_C_02.getErrorMessage()));
        }
    }

    private void verifyUserPhone(String phone){
        if(phone.matches(PHONE_PATTERN) == false) {
            throw new StoreDemoException(HttpStatus.BAD_REQUEST, new StoreDemoError(U_C_03, U_C_03.getErrorMessage()));
        }
    }


}