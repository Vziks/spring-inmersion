package info.vziks.api.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Class Config
 * Project appcontext
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
@Configuration
public class Config {
    @Bean(name = "popMusicConfig")
    public Music getPopMusic() {
        return new PopMusic();
    }
}