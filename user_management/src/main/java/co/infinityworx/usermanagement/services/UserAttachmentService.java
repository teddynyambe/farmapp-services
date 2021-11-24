package co.infinityworx.usermanagement.services;

import co.infinityworx.usermanagement.model.entity.UserAttachmentEntity;
import co.infinityworx.usermanagement.model.entity.UserEntity;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * User: Teddy Nyambe - InfinityWORX
 * Date: 16/07/2021
 * Time: 16:08
 * Project: user_management
 */
public interface UserAttachmentService {
    void saveUserAttachment(UserAttachmentEntity userAttachmentEntity);
    List<UserAttachmentEntity> findUserAttachmentById(UserEntity userEntity);
    void deleteUserAttachment(Long id);
}
