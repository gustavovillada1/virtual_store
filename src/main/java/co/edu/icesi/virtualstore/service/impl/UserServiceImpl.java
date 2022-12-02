package co.edu.icesi.virtualstore.service.impl;

import co.edu.icesi.virtualstore.error.exception.StoreDemoError;
import co.edu.icesi.virtualstore.error.exception.StoreDemoException;
import co.edu.icesi.virtualstore.model.User;
import co.edu.icesi.virtualstore.repository.UserRepository;
import co.edu.icesi.virtualstore.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    public final UserRepository userRepository;

    @Override
    public User getUser(UUID userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public User createUser(User user) {
        verifyEmailRepeat(user.getEmail())  ;
        verifyPhoneNumberRepeat(user.getPhone());
            return userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        List<User> userList=StreamSupport.stream(userRepository.findAll().spliterator(),false).collect(Collectors.toList());

        return userList;
    }

    public void verifyEmailRepeat(String email){
        for (User i:getUsers()) {
            if (i.getEmail().equals(email)){
                throw new StoreDemoException(HttpStatus.BAD_REQUEST, new StoreDemoError("1234","Email repeated in the database"));
            }
        }
    }

    public void verifyPhoneNumberRepeat(String phoneNumber){
        for (User i:getUsers()) {
            if (i.getPhone().equals(phoneNumber)){
                throw new StoreDemoException(HttpStatus.BAD_REQUEST, new StoreDemoError("1234","Phone repeated in the database"));

            }
        }
    }


}
