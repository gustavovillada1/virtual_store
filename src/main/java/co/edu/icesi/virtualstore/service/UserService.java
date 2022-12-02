package co.edu.icesi.virtualstore.service;

import co.edu.icesi.virtualstore.model.Role;
import co.edu.icesi.virtualstore.model.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

public interface UserService {

    public User getUser(@PathVariable UUID userId);

    public User createUser(@RequestBody User user, UUID roleId);

    public List<User> getUsers();

    public User updateUserRol(@PathVariable UUID userId, @RequestBody User updatedUser);
}
