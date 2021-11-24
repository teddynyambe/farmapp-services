package co.infinityworx.usermanagement.services;

import co.infinityworx.usermanagement.services.dto.UserDTO;

/**
 * Created by IntelliJ IDEA.
 * User: Teddy Nyambe - InfinityWORX
 * Date: 06/09/2021
 * Time: 12:46
 * Project: farm_services
 */
public interface KeycloakUserService {
    String userRegistration(UserDTO user);
    UserDTO getKeycloakUser(String username);
}
