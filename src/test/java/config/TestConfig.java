package config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = {"ru.testspring.jpa"})
@ComponentScan(basePackages = {"ru.testspring.service"})
@EntityScan(basePackages = {"ru.testspring.entities"})
public class TestConfig {
}
