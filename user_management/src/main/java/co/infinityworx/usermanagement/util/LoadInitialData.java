package co.infinityworx.usermanagement.util;

import co.infinityworx.usermanagement.config.KeycloakConfig;
import co.infinityworx.usermanagement.model.entity.*;
import co.infinityworx.usermanagement.model.repository.AttachmentTypeRepository;
import co.infinityworx.usermanagement.model.repository.UserAttachmentRepository;
import co.infinityworx.usermanagement.model.repository.UserRepository;
import co.infinityworx.usermanagement.util.enums.AttachmentType;
import co.infinityworx.usermanagement.util.enums.Roles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class LoadInitialData implements CommandLineRunner {
    private UserRepository userRepository;
    private AttachmentTypeRepository attachmentTypeRepository;
    private UserAttachmentRepository userAttachmentRepository;
    private KeycloakConfig keycloakConfig;
    Logger logger = LoggerFactory.getLogger(LoadInitialData.class);

    public LoadInitialData(UserRepository userRepository, AttachmentTypeRepository attachmentTypeRepository, UserAttachmentRepository userAttachmentRepository, KeycloakConfig keycloakConfig) {
        this.userRepository = userRepository;
        this.attachmentTypeRepository = attachmentTypeRepository;
        this.userAttachmentRepository = userAttachmentRepository;
        this.keycloakConfig = keycloakConfig;
    }

    @Override
    public void run(String... args) throws Exception {

        logger.info("==============Loading database data===========");
        ///Users
        userRepository.save(new UserEntity(1L, "6d4957f5-9a42-467d-b78c-04373f2d9e03","Sharon", "Nyambe", "sharon.nyambe@gmail.co", Roles.Owner, null, "0977760473"));
        userRepository.save(new UserEntity(3L, UUID.randomUUID().toString(),"Paul",  "Paul", "Lesa", Roles.Owner, "Infinity Worx", "0977760473"));
        logger.info("==============Loading data completed===========");
        ///Attachment Types
        attachmentTypeRepository.save(new AttachmentTypeEntity(1L, AttachmentType.Contract, AttachmentType.Contract.toString()));
        attachmentTypeRepository.save(new AttachmentTypeEntity(2L, AttachmentType.Identity_Document, AttachmentType.Identity_Document.toString()));
        attachmentTypeRepository.save(new AttachmentTypeEntity(3L, AttachmentType.Reference_Letter, AttachmentType.Reference_Letter.toString()));
        attachmentTypeRepository.save(new AttachmentTypeEntity(4L, AttachmentType.Personnel_Photo, AttachmentType.Personnel_Photo.toString()));
        ///Attachment
//        userAttachmentRepository.save(new UserAttachmentEntity(1L, userRepository.findById(4L).get(), attachmentTypeRepository.findById(7L).get(), new UploadedFile(1L, "paul_nrc.pdf", "pdf")));
//        userAttachmentRepository.save(new UserAttachmentEntity(2L, userRepository.findById(4L).get(), attachmentTypeRepository.findById(8L).get(), new UploadedFile(2L, "paul_ref.doc", "doc")));
//        userAttachmentRepository.save(new UserAttachmentEntity(3L, userRepository.findById(5L).get(), attachmentTypeRepository.findById(8L).get(), new UploadedFile(3L, "mwewa_ref.doc", "doc")));

    }
}
