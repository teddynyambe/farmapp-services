package co.infinityworx.usermanagement.services.impl;

import co.infinityworx.usermanagement.exception.NotFoundException;
import co.infinityworx.usermanagement.model.entity.UserEntity;
import co.infinityworx.usermanagement.model.repository.UserRepository;
import co.infinityworx.usermanagement.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    Class clazz;
    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(UserEntity user) {
//        user.setUserId(UUID.randomUUID().toString());
        userRepository.save(user);
    }

    @Override
    public UserEntity getUserByUserId(String userId) {
        return userRepository.findByUserId(userId);
    }

    @Override
    public List<UserEntity> getAllUsers() {
        List<UserEntity> userEntity = new ArrayList<>();
        userRepository.findAll().forEach(user -> userEntity.add(user));
        return userEntity;
    }

    @Override
    public void deleteUser(Long id) throws EmptyResultDataAccessException {
        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException exception) {
            throw new NotFoundException(String.format("Could not delete user with ID: %s, not found.", id));
        }
    }
}
