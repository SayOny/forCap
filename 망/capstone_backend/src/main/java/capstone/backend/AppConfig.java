package capstone.backend;

import capstone.backend.domain.Study;
import capstone.backend.service.LoginService;
import capstone.backend.service.StudyService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"capstone.backend"})
public class AppConfig {
    @Bean
    public LoginService loginService(){
        return new LoginService();
    }

    @Bean
    public StudyService studyService() {
        return new StudyService();
    }

}
