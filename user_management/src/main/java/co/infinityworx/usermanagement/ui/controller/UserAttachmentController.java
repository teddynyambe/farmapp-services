package co.infinityworx.usermanagement.ui.controller;

import co.infinityworx.usermanagement.model.entity.UserAttachmentEntity;
import co.infinityworx.usermanagement.model.entity.UserEntity;
import co.infinityworx.usermanagement.services.UserAttachmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Teddy Nyambe - InfinityWORX
 * Date: 16/07/2021
 * Time: 16:06
 * Project: user_management
 */
@RestController
@RequestMapping("/attachment")
public class UserAttachmentController {
    UserAttachmentService userAttachmentService;

    public UserAttachmentController(UserAttachmentService userAttachmentService) {
        this.userAttachmentService = userAttachmentService;
    }

    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>> getUserAttachmentsByUserId(@RequestBody UserEntity userEntity) {
        Map<String, Object> apiResponse = new LinkedHashMap<>();
        List<UserAttachmentEntity> allUserAttachments = this.userAttachmentService.findUserAttachmentById(userEntity);
        apiResponse.put("results", allUserAttachments == null ? new ArrayList<>() : allUserAttachments);
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @PostMapping("/save")
    public ResponseEntity<Void> saveUserAttachment(@RequestBody UserAttachmentEntity userAttachmentEntity) {
        userAttachmentService.saveUserAttachment(userAttachmentEntity);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @PutMapping("/update")
    public ResponseEntity<Void> updateUserAttachment(@RequestBody UserAttachmentEntity userAttachmentEntity) {
        userAttachmentService.saveUserAttachment(userAttachmentEntity);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUserAttachment(@PathVariable Long id) {
        userAttachmentService.deleteUserAttachment(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }


}
