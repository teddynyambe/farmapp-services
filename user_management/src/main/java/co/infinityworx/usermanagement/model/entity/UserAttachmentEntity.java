package co.infinityworx.usermanagement.model.entity;

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
@NoArgsConstructor
@AllArgsConstructor
@Table(name="iw_attachment")
public class UserAttachmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName="id")
    private UserEntity userid;
    @ManyToOne
    @JoinColumn(name = "attachment_type", referencedColumnName = "id")
    private AttachmentTypeEntity attachmentType;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="uploaded_file", referencedColumnName="id")
    private UploadedFile uploadedFile;
}
