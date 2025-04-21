package gachi.nikola.service.register;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"controller", "service", "repository"})
@EnableFeignClients(basePackages = "gachi.nikola.service.register.client")
public class ServiceConfiguration {
}
