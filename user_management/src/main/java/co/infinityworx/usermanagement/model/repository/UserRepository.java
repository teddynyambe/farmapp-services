package co.infinityworx.usermanagement.model.repository;

import co.infinityworx.usermanagement.model.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    UserEntity findByUserId (String userId);
}
