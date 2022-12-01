package co.edu.icesi.virtualstore.api;

import co.edu.icesi.virtualstore.dto.LoginDTO;
import co.edu.icesi.virtualstore.dto.TokenDTO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/login")
public interface LoginAPI {

    @PostMapping
    TokenDTO login(@RequestBody LoginDTO loginDTO);

}