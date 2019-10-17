package org.incode.estatiotoc.webapp;


import org.incode.estatiotoc.webapp.config.AppConfig;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@Import({
})
@EnableConfigurationProperties(AppConfig.class)
public class WebappModule {

}
