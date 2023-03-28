package fr.eni.filmotheque.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Configuration
public class I18Configuration implements WebMvcConfigurer {
    public LocaleChangeInterceptor intercept (){
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        interceptor.setParamName("language"); //mot clé à mettre en paramètre dans l'url
        return interceptor;
    }
    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(new Locale("fr", "FR"));
        return slr;
    }

    @Override //generate from interface WebMvcConfigurer
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(intercept());
    }
}

