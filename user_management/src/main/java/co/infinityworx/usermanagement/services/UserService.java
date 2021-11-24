package co.infinityworx.usermanagement.services;


import co.infinityworx.usermanagement.model.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void saveUser(UserEntity user);
    UserEntity getUserByUserId(String userId);
    List<UserEntity> getAllUsers();
    void deleteUser(Long id);
}
