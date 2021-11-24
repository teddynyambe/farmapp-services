package co.infinityworx.usermanagement.model.entity;

import co.infinityworx.usermanagement.util.enums.AttachmentType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: Teddy Nyambe - InfinityWORX
 * Date: 16/07/2021
 * Time: 15:36
 * Project: user_management
 */

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="iw_attachment_type")
public class AttachmentTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "attachment_type")
    private AttachmentType attachmentType;
    private String description;
}
