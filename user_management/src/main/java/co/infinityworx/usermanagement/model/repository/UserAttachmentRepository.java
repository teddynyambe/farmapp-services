package co.infinityworx.usermanagement.model.repository;

import co.infinityworx.usermanagement.model.entity.UserAttachmentEntity;
import co.infinityworx.usermanagement.model.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Teddy Nyambe - InfinityWORX
 * Date: 16/07/2021
 * Time: 16:07
 * Project: user_management
 */
public interface UserAttachmentRepository extends CrudRepository<UserAttachmentEntity, Long> {
    List<UserAttachmentEntity> findByUserid(UserEntity userEntity);
}
