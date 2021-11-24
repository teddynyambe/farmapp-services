package co.infinityworx.usermanagement.ui.controller;

import co.infinityworx.usermanagement.config.KeycloakConfig;
import co.infinityworx.usermanagement.model.entity.UserEntity;
import co.infinityworx.usermanagement.services.KeycloakUserService;
import co.infinityworx.usermanagement.services.UserService;
import co.infinityworx.usermanagement.services.dto.UserDTO;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;
    private KeycloakUserService keycloakUserService;
    private KeycloakConfig keycloakConfig;
    private ModelMapper modelMapper;
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    public UserController(UserService userService, KeycloakUserService keycloakUserService, KeycloakConfig keycloakConfig, ModelMapper modelMapper) {
        this.userService = userService;
        this.keycloakUserService = keycloakUserService;
        this.keycloakConfig = keycloakConfig;
        this.modelMapper = modelMapper;
    }

    @GetMapping(value = "/all", produces = {})
    public ResponseEntity<Map<String, Object>> getAllUser() {
        logger.info("======================== Getting ALl users");
        List<UserEntity> allUsers = userService.getAllUsers();
        Map<String, Object> userResponse = new LinkedHashMap<>();
        userResponse.put("results", allUsers);
        return ResponseEntity.status(HttpStatus.OK).body(userResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getUserById(@PathVariable String id) {
        Map<String, Object> userResponse = new LinkedHashMap<>();
        UserEntity userEntity = userService.getUserByUserId(id);
        userResponse.put("results", userEntity == null ? new ArrayList<>() : new ArrayList<UserEntity>() {
            {
                add(userEntity);
            }
        });
        return ResponseEntity.status(HttpStatus.OK).body(userResponse);
    }


    @PostMapping("/save")
    public ResponseEntity<Void> newUser(@RequestBody UserEntity userEntity) {
        userService.saveUser(userEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @PutMapping("/update")
    public ResponseEntity<Void> updateUser(@RequestBody UserEntity userEntity) {
        userService.saveUser(userEntity);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @PostMapping("/registration")
    public ResponseEntity<Void> registerUser(@RequestBody UserDTO user) {
        String userId = keycloakUserService.userRegistration(user);
        user.setUserId(userId);
        userService.saveUser(modelMapper.map(user, UserEntity.class));
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @GetMapping("/keycloak/{username}")
    public ResponseEntity<Map<String, Object>> getKeycloakUser(@PathVariable String username) {
        UserDTO keycloakUser = keycloakUserService.getKeycloakUser(username);
        Map<String, Object> userResponse = new LinkedHashMap<>();
        userResponse.put("results", keycloakUser);
        return ResponseEntity.status(HttpStatus.OK).body(userResponse);

    }
}
