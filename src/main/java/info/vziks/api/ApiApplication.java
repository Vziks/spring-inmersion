package info.vziks.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

@SpringBootApplication
@EnableScheduling
@EnableWebSecurity
@EnableJpaAuditing
@PropertySource("classpath:propertyContext.properties")
public class ApiApplication {


    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }

    @Bean
    RouterFunction<?> routerFunction() {
        return RouterFunctions.route().GET("/route/one", this::createRoute)
                .add(RouterFunctions.route().GET("/route/two", this::createRoute).build())
                .add(RouterFunctions.route().GET("/route/three", this::createRoute).build())
                .build();
    }

    private ServerResponse createRoute(ServerRequest serverRequest) {

        return ServerResponse.ok().render("create");
    }

}
