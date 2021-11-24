package co.infinityworx.usermanagement.config;

import lombok.ToString;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.RealmResource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;

/**
 * Created by IntelliJ IDEA.
 * User: Teddy Nyambe - InfinityWORX
 * Date: 06/09/2021
 * Time: 12:22
 * Project: farm_services
 */
@Configuration
@Scope("singleton")
@ToString
public class KeycloakConfig {
    Keycloak keycloak = null;
    @Value("${keycloak.auth-server-url}")
    String serverURL;
    @Value("${keycloak.realm}")
    String realm;
    @Value("${keycloak.resource}")
    String clientId;
//    @Value("$Value{keycloak.credentials.secret}")
//    String clientSecret;
    @Value("${keycloak.admin-username}")
    String username;
    @Value("${keycloak.admin-password}")
    String password;

    public KeycloakConfig() {
    }

    @PostConstruct
    private void init() {
        this.keycloak = KeycloakBuilder.builder()
                .serverUrl(this.serverURL)
//                .realm("master")
                .realm(realm)
                .grantType(OAuth2Constants.PASSWORD)
                .username(username)
                .password(password)
//                .clientId("admin-cli")
                .clientId(clientId)
//                .clientSecret(clientSecret)
                .resteasyClient(new ResteasyClientBuilder()
                        .connectionPoolSize(10)
                        .build())
                .build();
        this.keycloak.tokenManager().getAccessToken();
//        RealmResource realmResource = keycloak.realm(realm);

    }

    public Keycloak getKeycloak() {
        return keycloak;
    }

    public String getRealm() {
        return realm;
    }

}
