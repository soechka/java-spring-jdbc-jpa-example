import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = ("ru.testspring.jpa"))
@EntityScan(basePackages = ("ru.testspring.entities"))
@ComponentScan(basePackages = ("ru.testspring.services"))
public class TestConfig {
}
