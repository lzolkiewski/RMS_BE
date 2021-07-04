package com.kwlz.rms.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Lazy
@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI rmsOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title(LocaleConfig.getLocaleMessage("openAPITitle"))
                        .description(LocaleConfig.getLocaleMessage("openAPIDescription"))
                        .version("v1.0.0"));
    }

}