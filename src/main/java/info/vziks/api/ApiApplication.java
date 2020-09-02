package info.vziks.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

@SpringBootApplication
@EnableScheduling
@EnableWebSecurity
public class ApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }
    
    
    @Bean
    RouterFunction<?> routerFunction() {
        return RouterFunctions.route().GET("/route/one", this::createRoute).build()
                .and(RouterFunctions.route().GET("/route/two", this::createRoute).build())
                .and(RouterFunctions.route().GET("/route/three", this::createRoute).build());
    }

    private ServerResponse createRoute(ServerRequest serverRequest) {

        ServerResponse serverResponse = ServerResponse.ok().render("create");

        return serverResponse;
    }

}
