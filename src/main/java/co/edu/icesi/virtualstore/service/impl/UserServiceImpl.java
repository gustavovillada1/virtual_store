package co.edu.icesi.virtualstore.service.impl;

import co.edu.icesi.virtualstore.error.exception.StoreDemoError;
import co.edu.icesi.virtualstore.error.exception.StoreDemoException;
import co.edu.icesi.virtualstore.model.Role;
import co.edu.icesi.virtualstore.model.User;
import co.edu.icesi.virtualstore.repository.RoleRepository;
import co.edu.icesi.virtualstore.repository.UserRepository;
import co.edu.icesi.virtualstore.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static co.edu.icesi.virtualstore.constans.StoreErrorCode.*;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    public final UserRepository userRepository;

    public final RoleRepository roleRepository;

    @Override
    public User getUser(UUID userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public User createUser(User user, UUID roleId) {
        verifyEmailRepeat(user.getEmail());
        verifyPhoneRepeat(user.getPhone());
        Role role = verifyRoleExistence(roleId);
        user.setRole(role);
        return userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        //TODO Solo admin puede listar los usuarios
        return StreamSupport.stream(userRepository.findAll().spliterator(),false).collect(Collectors.toList());
    }

    @Override
    public User updateUserRol(UUID userId, UUID newRoleId) {
        Role role = verifyRoleExistence(newRoleId);
        User user = verifyUserExistence(userId);
        user.setRole(role);
        return userRepository.save(user);
    }

    private void verifyEmailRepeat(String email){
        if(userRepository.findByEmail(email).isPresent()){
            throw new StoreDemoException(HttpStatus.BAD_REQUEST, new StoreDemoError(U_S_01, U_S_01.getErrorMessage()));
        }
    }

    private void verifyPhoneRepeat(String phone){
        if (userRepository.findByPhone(phone).isPresent()){
            throw new StoreDemoException(HttpStatus.BAD_REQUEST, new StoreDemoError(U_S_02, U_S_02.getErrorMessage()));
        }
    }

    private Role verifyRoleExistence(UUID roleId){
        Role role = roleRepository.findById(roleId).orElse(null);
        if(role == null){
            throw new StoreDemoException(HttpStatus.BAD_REQUEST, new StoreDemoError(U_S_03, U_S_03.getErrorMessage()));
        }
        return role;
    }

    private User verifyUserExistence(UUID userId){
        User user = userRepository.findById(userId).orElse(null);
        if(user == null){
            throw new StoreDemoException(HttpStatus.BAD_REQUEST, new StoreDemoError(U_S_04, U_S_04.getErrorMessage()));
        }
        return user;
    }

}
