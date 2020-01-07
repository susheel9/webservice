package web.service.webservice.config;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import web.service.webservice.filter.UserFilter;

@Configuration
public class AppConfig {

    @Bean
    public FilterRegistrationBean someFilterRegistration() {

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new UserFilter());
        //registration.addUrlPatterns("/display/*");
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("userFilter");
        registration.setOrder(1);
        return registration;
    }

}
