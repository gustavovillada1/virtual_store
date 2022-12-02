package co.edu.icesi.virtualstore.controller;

import co.edu.icesi.virtualstore.api.UserAPI;
import co.edu.icesi.virtualstore.dto.UserCreateDTO;
import co.edu.icesi.virtualstore.dto.UserDTO;
import co.edu.icesi.virtualstore.error.exception.StoreDemoError;
import co.edu.icesi.virtualstore.error.exception.StoreDemoException;
import co.edu.icesi.virtualstore.mapper.UserMapper;
import co.edu.icesi.virtualstore.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@CrossOrigin
public class UserController implements UserAPI {

    private static Integer ERROR_NAME =101;
    private static Integer ERROR_LAST_NAME =102;
    private static Integer ERROR_PHONE =201;
    private static Integer ERROR_EMAIL =202;


    public final UserService userService;
    public final UserMapper userMapper;

    @Override
    public UserDTO getUser(UUID userId) {
        return userMapper.fromUser(userService.getUser(userId));
    }

    @Override
    public UserDTO createUser(UserCreateDTO userCreateDTO) {
        verifyUserEmailAndPhoneNumber(userCreateDTO.getEmail(), userCreateDTO.getPhone());
        return userMapper.fromUser( userService.createUser(userMapper.fromCreateDTO(userCreateDTO), userCreateDTO.getRoleId()) );
    }

    @Override
    public List<UserDTO> getUsers() {
        return userService.getUsers().stream().map(userMapper::fromUser).collect(Collectors.toList());

    }


    private boolean verifyUserEmailAndPhoneNumber(String email, String phone){
        boolean emailAndPhoneIsCorrect = false;
        if(phone != null){
            emailAndPhoneIsCorrect = verifyUserPhone(phone);
            if(!emailAndPhoneIsCorrect) {
                return false;
            }
        }

        if (email != null){
            emailAndPhoneIsCorrect = verifyUserEmail(email);
            if(!emailAndPhoneIsCorrect) {
                return false;
            }
        }
        return emailAndPhoneIsCorrect;
    }
    private boolean verifyUserEmail(String email){

        String[] divideEmail = email.split("@");

        //Verify if there is one @, later get the second part with de domain, and verify that the first part not have special characters

        if(divideEmail.length == 2 ){
            return true;
        }else{
            throw new StoreDemoException(HttpStatus.BAD_REQUEST, new StoreDemoError("1234","Throw UserDemoException - Email is not correct"));

        }
    }

    private boolean verifyUserPhone(String phone){

        //Verify if have the correct format of a colombian number phone +57XXXXXXXXXX
        if(phone.substring(0,3).equals("+57") && phone.substring(3,13).matches("^[0-9]*$") && phone.length() == 13){
            return true;
        }else{
            throw new StoreDemoException(HttpStatus.BAD_REQUEST, new StoreDemoError("1234","Throw UserDemoException - Phone is not correct"));
        }
    }
}