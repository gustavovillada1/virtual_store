package co.edu.icesi.virtualstore.controller;

import co.edu.icesi.virtualstore.api.LoginAPI;
import co.edu.icesi.virtualstore.dto.LoginDTO;
import co.edu.icesi.virtualstore.dto.TokenDTO;
import co.edu.icesi.virtualstore.service.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController implements LoginAPI {


    private final LoginService loginService;

    @Override
    public TokenDTO login(LoginDTO loginDTO) {
        return loginService.login(loginDTO);
    }
}
