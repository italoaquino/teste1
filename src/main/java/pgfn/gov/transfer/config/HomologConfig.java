package pgfn.gov.transfer.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.ParseException;

@Configuration
@Profile("homolog")
public class HomologConfig {

    @Bean
    public boolean instantiateDatabase() throws ParseException {
        return true;
    }

    /*@Bean
    public UserDetailsServiceImpl detailsService() {
        return new UserDetailsServiceImpl();
    }*/

}

