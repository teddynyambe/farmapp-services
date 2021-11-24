package co.infinityworx.usermanagement.services.dto;

import co.infinityworx.usermanagement.util.enums.Roles;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.management.relation.Role;

/**
 * Created by IntelliJ IDEA.
 * User: Teddy Nyambe - InfinityWORX
 * Date: 06/09/2021
 * Time: 12:20
 * Project: farm_services
 */
@Setter
@Getter
@ToString
public class UserDTO {
    private String userId;
    private String firstName;
    private String lastName;
    private String password;
    private String username;
    private String emailAddress;
    private String companyName;
    private String mobileNumber;
    private Roles role;
}
