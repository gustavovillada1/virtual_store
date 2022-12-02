package co.edu.icesi.virtualstore.controller;

import co.edu.icesi.virtualstore.dto.UserDTO;
import co.edu.icesi.virtualstore.mapper.UserMapper;
import co.edu.icesi.virtualstore.mapper.UserMapperImpl;
import co.edu.icesi.virtualstore.model.Permission;
import co.edu.icesi.virtualstore.model.Role;
import co.edu.icesi.virtualstore.model.User;
import co.edu.icesi.virtualstore.service.UserService;
import co.edu.icesi.virtualstore.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

public class UserControllerTest {


    private UserService userService;
    private UserController userController;
    private UserMapper userMapper;

    @BeforeEach
    public void init(){
        userService = mock(UserServiceImpl.class);
        userMapper = new UserMapperImpl();
        userController = new UserController(userService, userMapper);
    }

    @Test
    public void testCreateUser(){
        UUID userId = UUID.randomUUID();
        List<Permission> rolePermissions = new ArrayList<>();
        rolePermissions.add(new Permission(UUID.fromString("d45bb1c6-354f-4052-9381-009679b8f291"), "/users", "POST"));
        Role role = new Role(UUID.fromString("d45bb1c6-354f-4052-9381-009679b8f289"),
                "ADMIN",
                "Offers support to the application by creating and managing items, orders and users", rolePermissions);
        when(userService.createUser(any(), any())).thenReturn(new User(
                userId, "pradita@compunet.co", "ILoveJava1", "La U Calle 18", "+573990002233", role)
        );

        UserDTO testUser = new UserDTO(
                userId, "pradita@compunet.co", "ILoveJava1", "La U Calle 18", "+573990002233", role);

        assertEquals(testUser.getEmail(), userService.createUser(userMapper.fromDTO(testUser), role.getRoleId()).getEmail());

    }
}
