package co.infinityworx.farm_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(scanBasePackages = {
        "co.infinityworx.farm_management.model.repository.livestock",
        "co.infinityworx.farm_management.service",
        "co.infinityworx.farm_management.util",
        "co.infinityworx.farm_management.config",
        "co.infinityworx.farm_management.ui.controller"})
@EnableEurekaClient
public class FarmManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(FarmManagementApplication.class, args);
    }

}
