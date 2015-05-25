package by.qd64.config.spring;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(basePackages = {"by.qd64"},
        excludeFilters =
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class))
@PropertySource({"classpath:app.properties"})
public class ApplicationConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
