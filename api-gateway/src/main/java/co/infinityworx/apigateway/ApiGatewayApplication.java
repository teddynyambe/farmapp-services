package co.infinityworx.apigateway;

import io.netty.handler.logging.LogLevel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.WebSession;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class
ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

	@GetMapping("/")
	public Mono<String> home(WebSession webSession) {
		return Mono.just(webSession.getId());
	}

}
