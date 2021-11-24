package co.infinityworx.usermanagement.services.impl;
import co.infinityworx.usermanagement.config.KeycloakConfig;
import co.infinityworx.usermanagement.services.KeycloakUserService;
import co.infinityworx.usermanagement.services.dto.UserDTO;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.CreatedResponseUtil;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Teddy Nyambe - InfinityWORX
 * Date: 06/09/2021
 * Time: 12:46
 * Project: farm_services
 */
@Service
public class KeycloakUserServiceImpl implements KeycloakUserService {
    KeycloakConfig keycloakConfig;
    ModelMapper modelMapper;

    public KeycloakUserServiceImpl(KeycloakConfig keycloakConfig, ModelMapper modelMapper) {
        this.keycloakConfig = keycloakConfig;
        this.modelMapper = modelMapper;
    }

    @Override
    public String userRegistration(UserDTO user) {
        //user.setEmail(user.getUsername());
        UsersResource usersResource = keycloakConfig.getKeycloak().realm(keycloakConfig.getRealm()).users();
        CredentialRepresentation credentialRepresentation = createPasswordCredentials(user.getPassword());
        UserRepresentation kcUser = new UserRepresentation();
        kcUser.setUsername(user.getUsername());
        kcUser.setCredentials(Collections.singletonList(credentialRepresentation));
        kcUser.setFirstName(user.getFirstName());
        kcUser.setLastName(user.getLastName());
        kcUser.setEmail(user.getEmailAddress());
        kcUser.setEnabled(true);
        kcUser.setEmailVerified(false);
        Response response = usersResource.create(kcUser);
        return CreatedResponseUtil.getCreatedId(response);
    }

    @Override
    public UserDTO getKeycloakUser(String username) {
        UserRepresentation userRepresentation;
        UsersResource usersResource = keycloakConfig.getKeycloak().realm(keycloakConfig.getRealm()).users();
        List<UserRepresentation> userRepresentations = usersResource.search(username);
        if(userRepresentations.size() > 0) {
            userRepresentation = userRepresentations.get(0);
        } else {
            userRepresentation = null;
        }
        if(userRepresentation == null) {
            return null;
        } else {
            UserDTO mapUser = modelMapper.map(userRepresentation, UserDTO.class);
            mapUser.setUserId(userRepresentation.getId());
            return mapUser;
        }
    }

    private static CredentialRepresentation createPasswordCredentials(String password) {
        CredentialRepresentation passwordCredentials = new CredentialRepresentation();
        passwordCredentials.setTemporary(false);
        passwordCredentials.setType(OAuth2Constants.PASSWORD);
        passwordCredentials.setValue(password);
        return passwordCredentials;
    }
}
