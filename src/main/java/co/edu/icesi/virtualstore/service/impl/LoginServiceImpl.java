package co.edu.icesi.virtualstore.service.impl;

import co.edu.icesi.virtualstore.dto.LoginDTO;
import co.edu.icesi.virtualstore.dto.TokenDTO;
import co.edu.icesi.virtualstore.model.User;
import co.edu.icesi.virtualstore.repository.UserRepository;
import co.edu.icesi.virtualstore.service.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.StreamSupport;

@AllArgsConstructor
@Service
public class LoginServiceImpl implements LoginService {

    public final UserRepository userRepository;

    @Override
    public TokenDTO login(LoginDTO loginDTO) {

        User user = StreamSupport.stream(userRepository.findAll().spliterator(),false)
                .filter(user1 -> user1.getEmail().equals(loginDTO.getEmail()))
                .findFirst()
                .orElseThrow();
        if(user.getPassword().equals(loginDTO.getPassword())) {
            Map<String, String> claims = new HashMap<>();
            claims.put("userId", user.getId().toString());
            return null;//TokenDTO(JWTParser.createJWT(user.getId().toString(),user.getFirstName(), user.getFirstName(), claims,100000L));
        }
        throw new InvalidParameterException();

    }

}