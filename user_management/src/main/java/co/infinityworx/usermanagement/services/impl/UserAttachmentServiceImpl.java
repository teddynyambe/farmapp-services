package co.infinityworx.usermanagement.services.impl;

import co.infinityworx.usermanagement.exception.NotFoundException;
import co.infinityworx.usermanagement.model.entity.UserAttachmentEntity;
import co.infinityworx.usermanagement.model.entity.UserEntity;
import co.infinityworx.usermanagement.model.repository.UserAttachmentRepository;
import co.infinityworx.usermanagement.services.UserAttachmentService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * User: Teddy Nyambe - InfinityWORX
 * Date: 16/07/2021
 * Time: 16:11
 * Project: user_management
 */

@Service
public class UserAttachmentServiceImpl implements UserAttachmentService {
    private UserAttachmentRepository userAttachmentRepository;

    public UserAttachmentServiceImpl(UserAttachmentRepository userAttachmentRepository) {
        this.userAttachmentRepository = userAttachmentRepository;
    }

    @Override
    public void saveUserAttachment(UserAttachmentEntity userAttachmentEntity) {
        this.userAttachmentRepository.save(userAttachmentEntity);
    }

//    @Override
//    public List<UserAttachmentEntity> getAllUserAttachments() {
//        List<UserAttachmentEntity> userAttachments = new ArrayList<>();
//        this.userAttachmentRepository.findAll().forEach(attachment-> userAttachments.add(attachment));
//        return userAttachments;
//    }

    @Override
    public List<UserAttachmentEntity> findUserAttachmentById(UserEntity userEntity) {
        List<UserAttachmentEntity> attachments = new ArrayList<>();
        if(this.userAttachmentRepository.findByUserid(userEntity).isEmpty()) {
            return null;
        } else {
            this.userAttachmentRepository.findByUserid(userEntity).forEach(attachment -> attachments.add(attachment));
            return attachments;
        }
    }

    @Override
    public void deleteUserAttachment(Long id) throws EmptyResultDataAccessException {
        try {
            this.userAttachmentRepository.deleteById(id);
        } catch (EmptyResultDataAccessException exception) {
            throw new NotFoundException(String.format("Could not delete attachment with ID: %s, item not found.", id));
        }
    }
}
