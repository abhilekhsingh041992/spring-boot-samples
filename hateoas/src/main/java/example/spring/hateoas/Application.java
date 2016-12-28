package example.spring.hateoas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by sgupta on 12/27/16.
 */
@SpringBootApplication
@EnableJpaRepositories(basePackages = "example.spring.hateoas.domain.repository")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
