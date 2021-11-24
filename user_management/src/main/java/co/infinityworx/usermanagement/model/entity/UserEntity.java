package co.infinityworx.usermanagement.model.entity;

import co.infinityworx.usermanagement.util.enums.Roles;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "iw_users")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler"})
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "user_id", unique = true, nullable = false)
    private String userId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email_address")
    private String emailAddress;
    private Roles role;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "mobile_number")
    private String mobileNumber;

}
