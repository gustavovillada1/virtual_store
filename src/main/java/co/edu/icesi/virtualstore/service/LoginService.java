package co.edu.icesi.virtualstore.service;

import co.edu.icesi.virtualstore.dto.LoginDTO;
import co.edu.icesi.virtualstore.dto.TokenDTO;

public interface LoginService {

    TokenDTO login(LoginDTO loginDTO);

}